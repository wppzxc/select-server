package my.select.netData.up.teach;

import my.select.netData.up.PageBase;

/**
 * Created by wpp on 2017/5/14.
 */
public class GetTeachUp extends PageBase {
    private String name;
    private Integer state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
