package my.select.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import my.select.entity.User;
import my.select.enums.GeneralStateEnum;
import my.select.enums.ResponseMsgEnum;
import my.select.netData.down.DownBase;
import my.select.netData.down.PageDown;
import my.select.netData.up.user.GetUserUp;
import my.select.service.UserService;
import my.select.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wpp on 2017/3/9.
 */
@Controller
@RequestMapping(value = "/user"/*, produces={"text/html;charset=UTF-8;","application/json;"}*/)
public class UserHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserService userService;

    @RequestMapping(value = "/getAllUsers")
    @ResponseBody
    public String getAllUsers(GetUserUp up){
        PageDown down = new PageDown();
        List<User> users = userService.getAllUsers(up);
        down.setData(users);
        down.setState(ResponseMsgEnum.OK.getId());
        down.setTotalCount(userService.getAllUsersCount(up));
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/getUserOptions")
    @ResponseBody
    public String getUserOptions(String arg){
        DownBase down = new DownBase();
        GetUserUp up = new GetUserUp();
        up.setName(arg);
        up.setState(GeneralStateEnum.ON.getId());
        List<User> users = userService.getUserOptions(up);
        down.setData(users);
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/getSelfInfo")
    @ResponseBody
    public String getSelfInfo(Integer userId){
        DownBase down = new DownBase();
        User selfInfo = userService.getUserById(userId);
        if(selfInfo == null){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setData(selfInfo);
            down.setState(ResponseMsgEnum.OK.getId());
            down.setMsg(ResponseMsgEnum.OK.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/updateSelfInfo")
    @ResponseBody
    public String updateSelfInfo(User user){
        DownBase down = new DownBase();
        Integer rows = userService.updateUser(user);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateUserInfo(User user){
        DownBase down = new DownBase();
        Integer rows = userService.updateUser(user);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(Integer id){
        DownBase down = new DownBase();
        Integer rows = userService.deleteUserById(id);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }
}
