package my.select.service;

import my.select.entity.Role;
import my.select.netData.down.privilege.RMenu;
import my.select.netData.down.privilege.RUser;
import my.select.netData.up.privilege.GetRolesUp;

import java.util.List;

/**
 * Created by wpp on 2017/5/19.
 */
public interface RoleService {
    List<Role> getAllRoles(GetRolesUp up);
    Integer insertRole(Role role);
    Integer updateRole(Role role);
    Integer deleteRole(Integer id);
    List<RUser> getRoleUsers(Integer id);
    Integer insertRoleUser(List<Integer> userList,Integer roleId);
    Integer deleteRoleUser(Integer roleId);
    List<RMenu> getRoleMenus(Integer roleId);
    Integer deleteRoleMenu(Integer roleId);
    Integer insertRoleMenu(List<Integer> menuList,Integer roleId);
}
