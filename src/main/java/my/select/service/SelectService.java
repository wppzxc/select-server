package my.select.service;

import my.select.entity.Select;
import my.select.exception.RepeatChooseException;
import my.select.netData.down.select.GetSelectDown;
import my.select.netData.login.NetUser;
import my.select.netData.up.select.GetSelectUp;
import my.select.netData.up.select.InsertSelectUp;
import my.select.netData.up.select.UpdateSelectUp;

import java.util.List;

/**
 * Created by wpp on 2017/4/3.
 */
public interface SelectService {
    List<GetSelectDown> getAllSelects(GetSelectUp up);
    Select getSelectByTeachId(Integer teachId);
    Integer getAllSelectsCount(GetSelectUp up);
    Integer insertSelect(InsertSelectUp up);
    Integer deleteSelect(Integer id);
    Integer updateSelect(UpdateSelectUp up);
    Integer chooseSelect(NetUser user, Integer id) throws RepeatChooseException;
    Integer ascSelectCount(Integer selectId);
}
