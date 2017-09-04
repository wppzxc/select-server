package my.select.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wpp on 2017/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SelectInfoDaoTest {
    @Resource
    private SelectInfoDao selectInfoDao;

    @Test
    public void insertSelectInfo() throws Exception {
        long userId = 1;
        int id = 1;
        int rows = selectInfoDao.insertSelectInfo(1,1);
        System.out.println("rows = "+rows);
    }

}