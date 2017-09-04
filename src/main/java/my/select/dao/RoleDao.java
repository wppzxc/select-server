package my.select.dao;

import my.select.entity.Role;
import my.select.netData.down.privilege.RMenu;
import my.select.netData.down.privilege.RUser;
import my.select.netData.up.privilege.GetRolesUp;

import java.util.List;
import java.util.Map;

/**
 * Created by wpp on 2017/5/18.
 */
public interface RoleDao {
    List<Role> getAllRoles(GetRolesUp up);
    Integer insertRole(Role role);
    Integer updateRole(Role role);
    Integer deleteRole(Integer id);
    List<RUser> getRoleUsers(Integer id);
    Integer insertRoleUser(Map<String,Object> map);
    Integer deleteRoleUser(Integer roleId);
    List<RMenu> getRoleMenus(Integer roleId);
    Integer deleteRoleMenu(Integer roleId);
    Integer insertRoleMenu(Map<String,Object> map);
}
