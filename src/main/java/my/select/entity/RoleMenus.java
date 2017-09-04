package my.select.entity;

/**
 * Created by wpp on 2017/3/7.
 */
public class RoleMenus {
    // 角色id
    private int roleId;
    // 用户id
    private int userId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RoleMenus{" +
                ", roleId=" + roleId +
                ", userId=" + userId +
                '}';
    }
}
