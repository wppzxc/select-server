package my.select.entity;

import java.util.Date;

/**
 * Created by wpp on 2017/3/7.
 */
public class Role {
    private int id;
    // 角色名称
    private String name;
    // 创建时间
    private Date createDate;
    // 状态(0:废弃，1:生效)
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", state=" + state +
                '}';
    }
}
