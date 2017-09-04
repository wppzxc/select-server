package my.select.netData.down.select;

import java.util.Date;

/**
 * Created by wpp on 2017/5/17.
 */
public class GetSelectInfoDown {
    private Integer courseId;
    // 选课id
    private Integer selectId;
    // 任课教师id
    private Integer userId;
    // 选课开始时间
    private Date selectStartTime;
    // 选课结束时间
    private Date selectEndTime;
    private Integer state;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "GetSelectInfoDown{" +
                "courseId=" + courseId +
                ", selectId=" + selectId +
                ", userId=" + userId +
                ", selectStartTime=" + selectStartTime +
                ", selectEndTime=" + selectEndTime +
                ", state=" + state +
                '}';
    }
}
