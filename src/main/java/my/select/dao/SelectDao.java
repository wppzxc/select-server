package my.select.dao;

import my.select.entity.Select;
import my.select.netData.down.select.GetSelectDown;
import my.select.netData.up.select.GetSelectUp;
import my.select.netData.up.select.InsertSelectUp;
import my.select.netData.up.select.UpdateSelectUp;

import java.util.List;

/**
 * Created by wpp on 2017/4/3.
 */
public interface SelectDao {
    List<GetSelectDown> getAllSelects(GetSelectUp up);
    Select getSelectByTeachId(Integer teachId);
    Integer getAllSelectsCount(GetSelectUp up);
    Integer insertSelect(InsertSelectUp up);
    Integer deleteSelect(Integer id);
    Integer deleteSelectByCourseId(Integer courseId);
    Integer deleteSelectByTeachId(Integer teachId);
    Integer updateSelect(UpdateSelectUp up);
    Integer chooseSelect(Integer id);
    Integer ascSelectCount(Integer selectId);
}
