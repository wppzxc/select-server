package my.select.service;

import my.select.entity.SelectInfo;
import my.select.netData.down.select.GetSelectInfoDown;
import my.select.netData.up.select.GetSelectInfoUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wpp on 2017/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SelectInfoServiceTest {

    @Resource
    private SelectInfoService selectInfoService;
    @Test
    public void getSelectInfosByUser() throws Exception {

        GetSelectInfoUp up = new GetSelectInfoUp();
        up.setName("C语言");
        up.setUserId(1);

        List<GetSelectInfoDown> list = selectInfoService.getSelectInfosByUser(up);
        System.out.println("list={}"+list);
    }

    @Test
    public void deleteSelectInfo() throws Exception {
//        int a = selectInfoService.deleteSelectInfo(1);
//        System.out.println(a);
    }

    @Test
    public void updateSelectInfo() throws Exception {
    }

    @Test
    public void insertSelectInfo() throws Exception {
        SelectInfo info = new SelectInfo();
        info.setCreateTime(new Date());
        info.setSelectId(1);
        info.setUserId(1);
        info.setState(0);
//        int a = selectInfoService.insertSelectInfo(info);
//        System.out.println(a);
    }



}