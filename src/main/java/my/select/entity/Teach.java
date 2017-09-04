package my.select.entity;

/**
 * Created by wpp on 2017/3/7.
 */
public class Teach {
    private int id;
    // 用户id
    private int userId;
    // 课程id
    private int courseId;
    // 状态
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Teach{" +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", state=" + state +
                '}';
    }
}
