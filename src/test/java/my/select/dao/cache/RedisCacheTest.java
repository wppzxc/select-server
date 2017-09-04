package my.select.dao.cache;

import my.select.dao.SelectDao;
import my.select.entity.Select;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wpp on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class RedisCacheTest {
    private Integer id = 1;
    @Resource
    private RedisCache redisCache;
    @Resource
    private SelectDao selectDao;
    @Test
    public void getSelect() throws Exception {
//        Select select = redisCache.getSelect(id);
//        if(select == null){
//            select = selectDao.get
//        }
    }

    @Test
    public void setSelect() throws Exception {
    }

}