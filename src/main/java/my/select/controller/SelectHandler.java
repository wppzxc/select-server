package my.select.controller;

import my.select.dao.cache.RedisCache;
import my.select.entity.Select;
import my.select.enums.GeneralStateEnum;
import my.select.enums.ResponseMsgEnum;
import my.select.exception.NoCountException;
import my.select.exception.RepeatChooseException;
import my.select.netData.down.DownBase;
import my.select.netData.down.PageDown;
import my.select.netData.down.select.GetSelectDown;
import my.select.netData.down.select.GetSelectInfoDown;
import my.select.netData.login.NetUser;
import my.select.netData.up.select.GetSelectInfoUp;
import my.select.netData.up.select.GetSelectUp;
import my.select.netData.up.select.InsertSelectUp;
import my.select.netData.up.select.UpdateSelectUp;
import my.select.service.SelectInfoService;
import my.select.service.SelectService;
import my.select.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import sun.nio.ch.Net;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wpp on 2017/4/3.
 */
@Controller
@RequestMapping("/select")
public class SelectHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SelectService selectService;
    @Resource
    private SelectInfoService selectInfoService;
    @Resource
    private RedisCache redisCache;

    @RequestMapping("/getAllSelects")
    @ResponseBody
    public String getAllSelects(GetSelectUp up){
        PageDown down = new PageDown();
        List<GetSelectDown> selects = redisCache.getSelects(up);
        if(selects == null){
            selects = selectService.getAllSelects(up);
            if(selects != null){
                redisCache.setSelects(up,selects);
            }
        }
        Integer count = redisCache.getSelectCount(up);
        if(count == null){
            count = selectService.getAllSelectsCount(up);
            if(count != null){
                redisCache.setSelectCount(up,count);
            }
        }
        down.setData(selects);
        down.setTotalCount(count);
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/insertSelect")
    @ResponseBody
    public String insertSelect(InsertSelectUp up){
        DownBase down = new DownBase();
        Select s = selectService.getSelectByTeachId(up.getTeachId());
        int rows = 0;
        // 如果数据存在
        if(s != null){
            // 且状态为废弃，则改变状态并更新数据
            if(s.getState() != GeneralStateEnum.ON.getId()){
                s.setState(GeneralStateEnum.ON.getId());
                rows = selectService.updateSelect(new UpdateSelectUp(s));
            }else {
                down.setState(ResponseMsgEnum.DUPLICATION_DATA.getId());
                down.setMsg(ResponseMsgEnum.DUPLICATION_DATA.getMsg());
                return StringUtil.ObjectToJsonString(down);
            }
            // 如果数据不存在，则插入数据
        }else {
            rows = selectService.insertSelect(up);
        }
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/deleteSelect")
    @ResponseBody
    public String deleteSelect(Integer id){
        DownBase down = new DownBase();
        int rows = selectService.deleteSelect(id);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/updateSelect")
    @ResponseBody
    public String updateSelect(UpdateSelectUp up){
        DownBase down = new DownBase();
        int rows = selectService.updateSelect(up);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/chooseSelect")
    @ResponseBody
    public String chooseSelect(HttpServletRequest request,Integer id){
        DownBase down = new DownBase();
        NetUser user = (NetUser)request.getSession().getAttribute("user");
        try{
            int rows = selectService.chooseSelect(user,id);
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
            down.setState(ResponseMsgEnum.SUCCESS.getId());
        }catch (NoCountException e){
            down.setMsg(e.getMessage());
            down.setState(ResponseMsgEnum.NO_COUNT_ERROR.getId());
        } catch (RepeatChooseException e1){
            down.setMsg(e1.getMessage());
            down.setState(ResponseMsgEnum.REPEAT_CHOOSE_ERROR.getId());
        }catch (Exception e2){
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }

        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/getSelectInfo")
    @ResponseBody
    public String getSelectInfo(HttpServletRequest request,GetSelectInfoUp up){

        PageDown down = new PageDown();
        NetUser user = (NetUser)request.getSession().getAttribute("user");
        up.setUserId(user.getId());
        List<GetSelectInfoDown> list = selectInfoService.getSelectInfosByUser(up);
        down.setData(list);
        down.setTotalCount(selectInfoService.getSelectInfosCountByUser(up));
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());

        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/cancelChooseSelect")
    @ResponseBody
    public String cancelChooseSelect(HttpServletRequest request,Integer id){
        DownBase down = new DownBase();
        NetUser user = (NetUser)request.getSession().getAttribute("user");
        long userId = user.getId();
        int rows = selectInfoService.deleteSelectInfo(userId,id);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            selectService.ascSelectCount(id);
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }
}
