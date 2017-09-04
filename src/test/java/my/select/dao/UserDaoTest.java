package my.select.dao;

import my.select.entity.User;
import my.select.netData.up.user.GetUserUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by wpp on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserDaoTest {
    @Resource
    private UserDao userDao;
    @Test
    public void getUserByLogin() throws Exception {
        String number = "132979";
        String password = "09047X";
        System.out.println(userDao.getUserByLogin(number, password));
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = userDao.getAllUsers(new GetUserUp());
        for(User u:users){
            System.out.println(u);
        }
    }

    @Test
    public void updateUser() throws Exception {
        User user = userDao.getUserByNumber(132979);
        user.setPassword("09047X");
        user.setName("武鹏鹏");
        System.out.println(userDao.updateUser(user));
    }

}