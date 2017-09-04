package my.select.service;

import my.select.netData.up.course.GetCourseUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wpp on 2017/3/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CourseServiceTest {
    @Resource
    private CourseService courseService;
    @Test
    public void getAllCourses() throws Exception {
        GetCourseUp up = new GetCourseUp("",null);
        System.out.println(courseService.getAllCourses(up));
    }

    @Test
    public void deleteCourse() throws Exception {
        System.out.println(courseService.deleteCourse(14));
    }
}