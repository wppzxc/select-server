package my.select.service.serviceImpl;

import my.select.dao.SelectInfoDao;
import my.select.entity.SelectInfo;
import my.select.netData.down.select.GetSelectInfoDown;
import my.select.netData.up.select.GetSelectInfoUp;
import my.select.service.SelectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wpp on 2017/5/3.
 */
@Service
public class SelectInfoServiceImpl implements SelectInfoService {

    @Resource
    private SelectInfoDao selectInfoDao;

    public List<GetSelectInfoDown> getSelectInfosByUser(GetSelectInfoUp up) {
        return selectInfoDao.getSelectInfosByUser(up);
    }

    public Integer getSelectInfosCountByUser(GetSelectInfoUp up) {
        return selectInfoDao.getSelectInfosCountByUser(up);
    }

    public int deleteSelectInfo(long userId,Integer selectId) {
        return selectInfoDao.deleteSelectInfo(userId,selectId);
    }

    public int insertSelectInfo(long userId,int id) {
        return selectInfoDao.insertSelectInfo(userId,id);
    }
}
