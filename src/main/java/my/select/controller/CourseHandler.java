package my.select.controller;

import my.select.entity.Course;
import my.select.enums.GeneralStateEnum;
import my.select.enums.ResponseMsgEnum;
import my.select.netData.down.DownBase;
import my.select.netData.down.PageDown;
import my.select.service.CourseService;
import my.select.netData.up.course.GetCourseUp;
import my.select.netData.up.course.InsertCourseUp;
import my.select.netData.up.course.UpdateCourseUp;
import my.select.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wpp on 2017/3/22.
 */
@Controller
@RequestMapping(value = "/course")
public class CourseHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private CourseService courseService;

    @RequestMapping("/getAllCourses")
    @ResponseBody
    public String getAllCourses(GetCourseUp up){
        List<Course> courses = courseService.getAllCourses(up);
        PageDown down = new PageDown();
        down.setData(courses);
        down.setTotalCount(courseService.getAllCoursesCount(up));
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/insertCourse")
    @ResponseBody
    public String insertCourse(InsertCourseUp up){
        DownBase down = new DownBase();
        int rows = courseService.insertCourse(up);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/updateCourse")
    @ResponseBody
    public String updateCourse(UpdateCourseUp up){
        DownBase down = new DownBase();
        int rows = courseService.updateCourse(up);
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
            down.setState(ResponseMsgEnum.SUCCESS.getId());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public String deleteCourse(UpdateCourseUp up){
        DownBase down = new DownBase();
        int rows = courseService.deleteCourse(up.getId());
        if(rows <= 0){
            down.setState(ResponseMsgEnum.INNER_ERR.getId());
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }else {
            down.setState(ResponseMsgEnum.SUCCESS.getId());
            down.setMsg(ResponseMsgEnum.SUCCESS.getMsg());
        }
        return StringUtil.ObjectToJsonString(down);
    }

    @RequestMapping("/getCourseOptions")
    @ResponseBody
    public String getCourseOptions(String arg){
        DownBase down = new DownBase();
        GetCourseUp up = new GetCourseUp();
        up.setName(arg);
        up.setState(GeneralStateEnum.ON.getId());
        List<Course> courses = courseService.getCourseOptions(up);
        down.setData(courses);
        down.setState(ResponseMsgEnum.OK.getId());
        down.setMsg(ResponseMsgEnum.OK.getMsg());
        return StringUtil.ObjectToJsonString(down);
    }

}
