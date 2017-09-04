package my.select.service;

import my.select.entity.User;
import my.select.netData.down.privilege.RMenu;
import my.select.netData.up.user.GetUserUp;

import java.util.List;

/**
 * Created by wpp on 2017/3/8.
 */
public interface UserService {
    User getUserByLogin(String number,String password);
    User getUserByNumber(Integer number);
    User getUserById(Integer userId);
    List<User> getAllUsers(GetUserUp up);
    int getAllUsersCount(GetUserUp up);
    int updateUser(User user);
    List<User> getUserOptions(GetUserUp up);
    List<RMenu> getAllMenus(Integer userId);
    int deleteUserById(Integer id);
}
