package my.select.service.serviceImpl;

import my.select.dao.MenuDao;
import my.select.entity.Menu;
import my.select.netData.up.privilege.GetMenuUp;
import my.select.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wpp on 2017/5/19.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;
    public List<Menu> getAllMenus(GetMenuUp up) {
        return menuDao.getAllMenus(up);
    }

    public Integer insertMenu(Menu menu) {
        return menuDao.insertMenu(menu);
    }

    public Integer deleteMenu(Integer id) {
        return menuDao.deleteMenu(id);
    }

    public Integer updateMenu(Menu menu) {
        return menuDao.updateMenu(menu);
    }
}
