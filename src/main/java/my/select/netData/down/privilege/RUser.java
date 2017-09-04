package my.select.netData.down.privilege;

import my.select.entity.User;

/**
 * Created by wpp on 2017/5/19.
 */
public class RUser {
    private Integer id;
    private String name;

    public RUser() {
    }

    public RUser(User user) {
        this.id = (int)user.getId();
        this.name = user.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
