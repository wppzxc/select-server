package my.select.service;

import my.select.entity.Teach;
import my.select.netData.down.teach.GetTeachOptionsDown;
import my.select.netData.up.teach.GetTeachOptionsUp;
import my.select.netData.up.teach.GetTeachUp;
import my.select.netData.up.teach.InsertTeachUp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wpp on 2017/5/14.
 */
public interface TeachService {
    List<Teach> getAllTeach(GetTeachUp up);
    Teach getTeachByUserIdAndCourseId(@Param("userId")long userId, @Param("courseId")int courseId);
    Integer getAllTeachCount(GetTeachUp up);
    Integer insertTeach(InsertTeachUp up);
    Integer updateTeach(Teach teach);
    Integer deleteTeach(Integer id);
    List<GetTeachOptionsDown> getTeachOptions(GetTeachOptionsUp up);
}
