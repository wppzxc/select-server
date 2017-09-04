package my.select.service.serviceImpl;

import my.select.dao.RoleDao;
import my.select.entity.Role;
import my.select.netData.down.privilege.RMenu;
import my.select.netData.down.privilege.RUser;
import my.select.netData.up.privilege.GetRolesUp;
import my.select.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wpp on 2017/5/19.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    public List<Role> getAllRoles(GetRolesUp up) {
        return roleDao.getAllRoles(up);
    }

    public Integer insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    public Integer updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    public Integer deleteRole(Integer id) {
        return roleDao.deleteRole(id);
    }

    public List<RUser> getRoleUsers(Integer id) {
        return roleDao.getRoleUsers(id);
    }

    public Integer insertRoleUser(List<Integer> userList, Integer roleId) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userList",userList);
        map.put("roleId",roleId);
        return roleDao.insertRoleUser(map);
    }

    public Integer deleteRoleUser(Integer roleId) {
        return roleDao.deleteRoleUser(roleId);
    }

    public List<RMenu> getRoleMenus(Integer roleId) {
        return roleDao.getRoleMenus(roleId);
    }

    public Integer deleteRoleMenu(Integer roleId) {
        return roleDao.deleteRoleMenu(roleId);
    }

    public Integer insertRoleMenu(List<Integer> menuList, Integer roleId) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("menuList",menuList);
        map.put("roleId",roleId);
        return roleDao.insertRoleMenu(map);
    }
}
