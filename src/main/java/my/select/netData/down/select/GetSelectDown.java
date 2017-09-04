package my.select.netData.down.select;

import java.util.Date;

/**
 * Created by wpp on 2017/5/14.
 */
public class GetSelectDown {
    private int id;
    // 授课id
    private int teachId;
    // 课程id
    private int courseId;
    // 教师id
    private int userId;
    // 数量
    private int count;
    // 创建时间
    private Date createTime;
    // 抽签时间
    private Date drawTime;
    // 选课开始时间
    private Date selectStartTime;
    // 选课结束时间
    private Date selectEndTime;
    // 状态(-1：未选中，0：提交选课，1：成功选中，2：已结课)
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeachId() {
        return teachId;
    }

    public void setTeachId(int teachId) {
        this.teachId = teachId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(Date drawTime) {
        this.drawTime = drawTime;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "GetSelectDown{" +
                "id=" + id +
                ", teachId=" + teachId +
                ", courseId=" + courseId +
                ", userId=" + userId +
                ", count=" + count +
                ", createTime=" + createTime +
                ", drawTime=" + drawTime +
                ", selectStartTime=" + selectStartTime +
                ", selectEndTime=" + selectEndTime +
                ", state=" + state +
                '}';
    }
}
