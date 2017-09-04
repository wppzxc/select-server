package my.select.service;

import my.select.entity.User;
import my.select.netData.up.user.GetUserUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wpp on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserService userService;
    @Test
    public void getUserByLogin() throws Exception {

    }

    @Test
    public void getUserByNumber() throws Exception {

    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = userService.getAllUsers(new GetUserUp());
        logger.info("list={}",users);
    }

    @Test
    public void updateUser() throws Exception {

    }

}