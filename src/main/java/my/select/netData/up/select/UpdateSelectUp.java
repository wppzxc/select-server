package my.select.netData.up.select;

import my.select.entity.Select;

import java.util.Date;

/**
 * Created by wpp on 2017/5/15.
 */
public class UpdateSelectUp {
    private Integer id;
    private Integer teachId;
    private Date selectStartTime;
    private Date selectEndTime;
    private Integer count;
    private Integer state;

    public UpdateSelectUp() {
    }

    public UpdateSelectUp(Select select) {
        this.id = select.getId();
        this.count = select.getCount();
        this.selectStartTime = select.getSelectStartTime();
        this.selectEndTime = select.getSelectEndTime();
        this.count = select.getCount();
        this.state = select.getState();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeachId() {
        return teachId;
    }

    public void setTeachId(Integer teachId) {
        this.teachId = teachId;
    }

    public Date getSelectStartTime() {
        return selectStartTime;
    }

    public void setSelectStartTime(Date selectStartTime) {
        this.selectStartTime = selectStartTime;
    }

    public Date getSelectEndTime() {
        return selectEndTime;
    }

    public void setSelectEndTime(Date selectEndTime) {
        this.selectEndTime = selectEndTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
