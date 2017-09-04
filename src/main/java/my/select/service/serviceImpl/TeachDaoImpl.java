package my.select.service.serviceImpl;

import my.select.dao.SelectDao;
import my.select.dao.TeachDao;
import my.select.entity.Teach;
import my.select.netData.down.teach.GetTeachOptionsDown;
import my.select.netData.up.teach.GetTeachOptionsUp;
import my.select.netData.up.teach.GetTeachUp;
import my.select.netData.up.teach.InsertTeachUp;
import my.select.service.TeachService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wpp on 2017/5/14.
 */
@Service
public class TeachDaoImpl implements TeachService {

    @Resource
    private TeachDao teachDao;
    @Resource
    private SelectDao selectDao;

    public List<Teach> getAllTeach(GetTeachUp up) {
        return teachDao.getAllTeach(up);
    }

    public Teach getTeachByUserIdAndCourseId(long userId, int courseId) {
        return teachDao.getTeachByUserIdAndCourseId(userId,courseId);
    }

    public Integer getAllTeachCount(GetTeachUp up) {
        return teachDao.getAllTeachCount(up);
    }

    public Integer insertTeach(InsertTeachUp up) {
        return teachDao.insertTeach(up);
    }

    public Integer updateTeach(Teach teach) {
        return teachDao.updateTeach(teach);
    }

    public Integer deleteTeach(Integer id) {
        return teachDao.deleteTeach(id) +
                selectDao.deleteSelectByTeachId(id);
    }

    public List<GetTeachOptionsDown> getTeachOptions(GetTeachOptionsUp up) {
        return teachDao.getTeachOptions(up);
    }
}
