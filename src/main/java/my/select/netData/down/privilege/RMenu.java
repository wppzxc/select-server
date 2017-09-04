package my.select.netData.down.privilege;

import my.select.entity.Menu;

/**
 * Created by wpp on 2017/5/20.
 */
public class RMenu {
    private Integer id;
    private String name;
    private String enName;
    private String module;

    public RMenu() {
    }

    public RMenu(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.module = menu.getModule();
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

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
