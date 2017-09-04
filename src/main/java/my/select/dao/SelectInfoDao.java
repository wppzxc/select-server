package my.select.dao;

import my.select.entity.SelectInfo;
import my.select.netData.down.select.GetSelectInfoDown;
import my.select.netData.up.select.GetSelectInfoUp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wpp on 2017/5/3.
 */
public interface SelectInfoDao {
    List<GetSelectInfoDown> getSelectInfosByUser(GetSelectInfoUp up);
    Integer getSelectInfosCountByUser(GetSelectInfoUp up);
    int deleteSelectInfo(@Param("userId")long userId, @Param("selectId")int selectId);
    int insertSelectInfo(@Param("userId")long userId, @Param("selectId")int selectId);
}
