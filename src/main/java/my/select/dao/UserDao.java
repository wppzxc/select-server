package my.select.dao;

import my.select.entity.Menu;
import my.select.entity.User;
import my.select.netData.down.privilege.RMenu;
import my.select.netData.up.user.GetUserUp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wpp on 2017/3/7.
 */
public interface UserDao {
    User getUserByLogin(@Param("number") String number, @Param("password") String password);
    User getUserByNumber(Integer number);
    User getUserById(Integer userId);
    List<User> getAllUsers(GetUserUp up);
    int getAllUsersCount(GetUserUp up);
    Integer updateUser(User user);
    List<User> getUserOptions(GetUserUp up);
    List<RMenu> getAllMenus(Integer userId);
    int deleteUserById(Integer id);
}
