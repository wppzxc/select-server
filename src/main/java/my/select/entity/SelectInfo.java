package my.select.entity;

import java.util.Date;

/**
 * Created by wpp on 2017/5/3.
 */
public class SelectInfo {
    private int userId;
    private int selectId;
    private Date createTime;
    private int state;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSelectId() {
        return selectId;
    }

    public void setSelectId(int selectId) {
        this.selectId = selectId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SelectInfo{" +
                ", userId=" + userId +
                ", selectId=" + selectId +
                ", createTime=" + createTime +
                ", state=" + state +
                '}';
    }
}
