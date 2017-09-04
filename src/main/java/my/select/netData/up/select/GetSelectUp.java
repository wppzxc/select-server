package my.select.netData.up.select;

import my.select.netData.up.PageBase;

/**
 * Created by wpp on 2017/5/15.
 */
public class GetSelectUp extends PageBase {
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

    @Override
    public String toString() {
        return "GetSelectUp{" +
                "offset=" + this.getOffset()+
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
