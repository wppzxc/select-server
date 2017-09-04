package my.select.controller;

import my.select.entity.Teach;
import my.select.enums.GeneralStateEnum;
import my.select.enums.ResponseMsgEnum;
import my.select.netData.down.DownBase;
import my.select.netData.down.PageDown;
import my.select.netData.down.teach.GetTeachOptionsDown;
import my.select.netData.login.NetUser;
import my.select.netData.up.teach.GetTeachOptionsUp;
import my.select.netData.up.teach.GetTeachUp;
import my.select.netData.up.teach.InsertTeachUp;
import my.select.service.TeachService;
import my.select.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wpp on 2017/5/14.
 */
@Controller
@RequestMapping("/teach")
public class TeachHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TeachService teachService;

    @RequestMapping("/getAllTeach")
    @ResponseBody
    public String getAllTeach(GetTeachUp up){
        List<Teach> teaches = teachService.getAllTeach(up);
        PageDown down = new PageDown();
        down.setData(teaches);
        down.setTotalCount(teachService.getAllTeachCount(up));
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/insertTeach")
    @ResponseBody
    public String insertTeach(InsertTeachUp up){
        DownBase down = new DownBase();
        Teach t = teachService.getTeachByUserIdAndCourseId(up.getUserId(),up.getCourseId());
        int rows = 0;
        // 如果数据存在
        if(t != null){
            // 且状态为废弃，则改变状态并更新数据
            if(t.getState() != GeneralStateEnum.ON.getId()){
                t.setState(GeneralStateEnum.ON.getId());
                rows = teachService.updateTeach(t);
            }else {
                down.setState(ResponseMsgEnum.DUPLICATION_DATA.getId());
                down.setMsg(ResponseMsgEnum.DUPLICATION_DATA.getMsg());
                return StringUtil.ObjectToJsonString(down);
            }
            // 如果数据不存在，则插入数据
        }else {
            rows = teachService.insertTeach(up);
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

    @ResponseBody
    @RequestMapping("/deleteTeach")
    public String deleteTeach(Integer id){
        DownBase down = new DownBase();
        int rows = teachService.deleteTeach(id);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/updateTeach")
    @ResponseBody
    public String updateTeach(Teach teach){
        DownBase down = new DownBase();
        int rows = teachService.updateTeach(teach);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
            down.setState(ResponseMsgEnum.SUCCESS.getId());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/getTeachOptions")
    @ResponseBody
    public String getTeachOptions(GetTeachOptionsUp up){
        up.setState(GeneralStateEnum.ON.getId());
        DownBase down = new DownBase();
        List<GetTeachOptionsDown> list = teachService.getTeachOptions(up);
        down.setData(list);
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }
}
