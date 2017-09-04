package my.select.service;

import my.select.netData.down.select.GetSelectInfoDown;
import my.select.netData.up.select.GetSelectInfoUp;

import java.util.List;

/**
 * Created by wpp on 2017/5/3.
 */
public interface SelectInfoService {
    List<GetSelectInfoDown> getSelectInfosByUser(GetSelectInfoUp up);
    Integer getSelectInfosCountByUser(GetSelectInfoUp up);
    int deleteSelectInfo(long userId,Integer selectId);
    int insertSelectInfo(long userId,int id);
}
