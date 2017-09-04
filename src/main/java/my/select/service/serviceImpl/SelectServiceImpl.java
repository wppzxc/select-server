package my.select.service.serviceImpl;

import my.select.dao.SelectDao;
import my.select.dao.SelectInfoDao;
import my.select.entity.Select;
import my.select.enums.ResponseMsgEnum;
import my.select.exception.NoCountException;
import my.select.exception.RepeatChooseException;
import my.select.netData.down.select.GetSelectDown;
import my.select.netData.login.NetUser;
import my.select.netData.up.select.GetSelectUp;
import my.select.netData.up.select.InsertSelectUp;
import my.select.netData.up.select.UpdateSelectUp;
import my.select.service.SelectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wpp on 2017/4/3.
 */
@Service
public class SelectServiceImpl implements SelectService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SelectDao selectDao;
    @Resource
    private SelectInfoDao selectInfoDao;

    public List<GetSelectDown> getAllSelects(GetSelectUp up) {
        return selectDao.getAllSelects(up);
    }

    public Select getSelectByTeachId(Integer teachId) {
        return selectDao.getSelectByTeachId(teachId);
    }

    public Integer getAllSelectsCount(GetSelectUp up) {
        return selectDao.getAllSelectsCount(up);
    }

    public Integer insertSelect(InsertSelectUp up) {
        return selectDao.insertSelect(up);
    }

    public Integer deleteSelect(Integer id) {
        return selectDao.deleteSelect(id);
    }

    public Integer updateSelect(UpdateSelectUp up) {
        return selectDao.updateSelect(up);
    }

    @Transactional
    public Integer chooseSelect(NetUser user, Integer id) throws RepeatChooseException {
        long userId = user.getId();
        try {
            int rows2 = selectInfoDao.insertSelectInfo(userId, id);
            if (rows2 <= 0) {
                throw new RepeatChooseException(ResponseMsgEnum.REPEAT_CHOOSE_ERROR.getMsg());
            } else {
                int rows = selectDao.chooseSelect(id);
                if (rows <= 0) {
                    throw new NoCountException(ResponseMsgEnum.NO_COUNT_ERROR.getMsg());
                } else {
                    return 1;
                }
            }
        } catch (RepeatChooseException e1) {
            throw e1;
        } catch (NoCountException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new NoCountException(e3.getMessage());
        }
    }

    public Integer ascSelectCount(Integer selectId) {
        return selectDao.ascSelectCount(selectId);
    }
}
