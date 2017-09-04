package my.select.service;

import my.select.entity.Course;
import my.select.netData.up.course.GetCourseUp;
import my.select.netData.up.course.InsertCourseUp;
import my.select.netData.up.course.UpdateCourseUp;

import java.util.List;

/**
 * Created by wpp on 2017/3/22.
 */
public interface CourseService {
    List<Course> getAllCourses(GetCourseUp up);
    Integer getAllCoursesCount(GetCourseUp up);
    Integer insertCourse(InsertCourseUp up);
    Integer updateCourse(UpdateCourseUp up);
    Integer deleteCourse(Integer id);
    List<Course> getCourseOptions(GetCourseUp up);
}
