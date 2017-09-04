package my.select.service;

import my.select.dao.SelectDao;
import my.select.entity.Select;
import my.select.entity.Teach;
import my.select.enums.ResponseMsgEnum;
import my.select.exception.RepeatChooseException;
import my.select.netData.down.DownBase;
import my.select.netData.login.NetUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wpp on 2017/4/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SelectServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SelectDao selectDao;
    @Resource
    private SelectService selectService;

    @Test
    public void getAllSelects() throws Exception {
//        logger.info("info={}",selectDao.getAllSelects());
    }

    @Test
    public void chooseSelect() throws RepeatChooseException {
        int id = 1;
        NetUser user = new NetUser();
        user.setId(1);
        DownBase down = new DownBase();
        try{
            int rows = selectService.chooseSelect(user,id);
        }catch (RepeatChooseException e1){
            down.setMsg(e1.getMessage());
        }catch (Exception e2){
            down.setMsg(ResponseMsgEnum.INNER_ERR.getMsg());
        }
    }

    @Test
    public void getSelectByTeachId(){
        int teachId = 1;
        Select t = selectService.getSelectByTeachId(teachId);
        System.out.println("select={}" + t);
    }

}