package my.select.system;

import my.select.dao.cache.RedisCache;
import my.select.entity.Course;
import my.select.entity.User;
import my.select.enums.ResponseMsgEnum;
import my.select.netData.down.DownBase;
import my.select.netData.down.course.NetCourse;
import my.select.netData.down.privilege.RMenu;
import my.select.netData.login.LoginUp;
import my.select.netData.login.NetUser;
import my.select.netData.up.course.GetCourseUp;
import my.select.netData.up.user.GetUserUp;
import my.select.service.CourseService;
import my.select.service.UserService;
import my.select.utils.DesUtil;
import my.select.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by wpp on 2017/4/28.
 * 登录模块
 */
@Controller
@RequestMapping("/system")
public class LoginHandler {

    @Resource
    private UserService userService;
    @Resource
    private CourseService courseService;
    @Resource
    private RedisCache redisCache;

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, LoginUp up){
        DownBase down = new DownBase();
        String number = up.getNumber();
        String password = up.getPassword();
        String desNumber = "";
        String desPassword = "";
        try{
            desNumber = DesUtil.strDec(number,"wpp",null,null);
            desPassword = DesUtil.strDec(password,"wpp",null,null);
        }catch (Exception e){
            e.printStackTrace();
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
            return StringUtil.ObjectToJsonString(down);
        }
        request.getSession().invalidate();
        User user = userService.getUserByLogin(desNumber,desPassword);
        String token = request.getSession().getId();

        if(user != null){

            // 获取所有用户id和姓名
            List<NetUser> netUsers = redisCache.getUsers("loginAllUsers");
            if(netUsers == null){
                GetUserUp getUserUp = new GetUserUp();
                getUserUp.setState(null);
                getUserUp.setName("");
                List<User> users = userService.getAllUsers(getUserUp);
                if(users != null){
                    netUsers = new ArrayList<NetUser>();
                    for(User u:users){
                        netUsers.add(new NetUser(u));
                    }
                    redisCache.setUsers("loginAllUsers",netUsers);
                }
            }

            // 获取所有课程id和姓名
            List<NetCourse> netCourses = redisCache.getCourses("loginAllCourses");
            if(netCourses == null){
                GetCourseUp getCourseUp = new GetCourseUp();
                getCourseUp.setState(null);
                getCourseUp.setName("");
                List<Course> courses = courseService.getAllCourses(getCourseUp);
                if(courses != null){
                    netCourses = new ArrayList<NetCourse>();
                    for(Course c:courses){
                        netCourses.add(new NetCourse(c));
                    }
                    redisCache.setCourses("loginAllCourses",netCourses);
                }
            }

            // 获取该用户所有权限
            List<RMenu> menus = userService.getAllMenus((int) user.getId());

            Map<String,Object> map = new HashMap<String, Object>();
            NetUser netUser = new NetUser(user);
            netUser.setToken(token);
            map.put("user",netUser);
            map.put("users",netUsers);
            map.put("courses",netCourses);
            map.put("menus",menus);
            request.getSession().setAttribute("user",netUser);
            request.getSession().setAttribute("users",netUsers);
            request.getSession().setAttribute("courses",netCourses);
            request.getSession().setAttribute("menus",menus);
            down.setData(map);
            down.setState(ResponseMsgEnum.LOGIN.getId());
            down.setMsg(ResponseMsgEnum.LOGIN.getMsg());
        }else {
            down.setState(ResponseMsgEnum.REQ_ERR.getId());
            down.setMsg("登录失败,用户不存在！");
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request){
        DownBase down = new DownBase();
        request.getSession().invalidate();
        down.setState(ResponseMsgEnum.LOGOUT.getId());
        down.setMsg(ResponseMsgEnum.LOGOUT.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/timeout")
    @ResponseBody
    public String timeout(HttpServletRequest request){
        DownBase down = new DownBase();
        request.getSession().invalidate();
        down.setState(ResponseMsgEnum.TIMEOUT.getId());
        down.setMsg(ResponseMsgEnum.TIMEOUT.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/noPrivilege")
    @ResponseBody
    public String noPrivilege(){
        DownBase down = new DownBase();
        down.setState(ResponseMsgEnum.NO_PRIVILEGE.getId());
        down.setMsg(ResponseMsgEnum.NO_PRIVILEGE.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }
}
