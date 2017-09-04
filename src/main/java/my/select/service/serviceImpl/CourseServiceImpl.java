package my.select.service.serviceImpl;

import my.select.dao.CourseDao;
import my.select.dao.SelectDao;
import my.select.dao.TeachDao;
import my.select.entity.Course;
import my.select.netData.up.course.GetCourseUp;
import my.select.service.CourseService;
import my.select.netData.up.course.InsertCourseUp;
import my.select.netData.up.course.UpdateCourseUp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wpp on 2017/3/22.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;
    @Resource
    private TeachDao teachDao;
    @Resource
    private SelectDao selectDao;
    public List<Course> getAllCourses(GetCourseUp up) {
        return courseDao.getAllCourses(up);
    }

    public Integer getAllCoursesCount(GetCourseUp up) {
        return courseDao.getAllCoursesCount(up);
    }

    public Integer insertCourse(InsertCourseUp up) {
        return courseDao.insertCourse(up);
    }

    public Integer updateCourse(UpdateCourseUp up) {
        return courseDao.updateCourse(up);
    }

    public Integer deleteCourse(Integer id) {
        return courseDao.deleteCourse(id) +
                teachDao.deleteTeachByCourseId(id) +
                selectDao.deleteSelectByCourseId(id);
    }

    public List<Course> getCourseOptions(GetCourseUp up) {
        return courseDao.getCourseOptions(up);
    }
}
