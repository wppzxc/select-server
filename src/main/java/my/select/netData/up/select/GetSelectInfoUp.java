package my.select.netData.up.select;

import my.select.netData.up.PageBase;

/**
 * Created by wpp on 2017/5/17.
 */
public class GetSelectInfoUp extends PageBase {
    private long userId;
    private String name;
    private Integer state;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

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
