package my.select.service.serviceImpl;

import my.select.dao.UserDao;
import my.select.entity.User;
import my.select.netData.down.privilege.RMenu;
import my.select.netData.up.user.GetUserUp;
import my.select.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wpp on 2017/3/8.
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserDao userDao;
    public User getUserByLogin(String number, String password) {
        return userDao.getUserByLogin(number,password);
    }

    public User getUserByNumber(Integer number) {
        return userDao.getUserByNumber(number);
    }

    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    public List<User> getAllUsers(GetUserUp up) {
        return userDao.getAllUsers(up);
    }

    public int getAllUsersCount(GetUserUp up) {
        return userDao.getAllUsersCount(up);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public List<User> getUserOptions(GetUserUp up) {
        return userDao.getUserOptions(up);
    }

    public List<RMenu> getAllMenus(Integer userId) {
        return userDao.getAllMenus(userId);
    }

    public int deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }
}
