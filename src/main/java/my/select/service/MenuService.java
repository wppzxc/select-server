package my.select.service;

import my.select.entity.Menu;
import my.select.netData.up.privilege.GetMenuUp;

import java.util.List;

/**
 * Created by wpp on 2017/5/19.
 */
public interface MenuService {
    List<Menu> getAllMenus(GetMenuUp up);
    Integer insertMenu(Menu menu);
    Integer deleteMenu(Integer id);
    Integer updateMenu(Menu menu);
}
