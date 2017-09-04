package my.select.entity;

import java.util.Date;

/**
 * Created by wpp on 2017/3/7.
 */
public class Menu {
    private int id;
    // 菜单名称
    private String name;
    // 菜单英文名称
    private String enName;
    // 路径
    private String path;
    // 所属模块
    private String module;
    // 状态(0:废弃，1:生效)
    private int state;
    // 是否受权限控制
    private Integer visible;

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

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", visible=" + visible +
                '}';
    }
}
