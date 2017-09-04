package my.select.dao;

import my.select.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wpp on 2017/3/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CourseDaoTest {
    @Resource
    private CourseDao courseDao;
    @Test
    public void getAllCourses() throws Exception {
        List<Course> list = courseDao.getAllCourses(null);
        System.out.println(list);
    }

}