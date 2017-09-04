package my.select.entity;

import java.util.Date;

/**
 * Created by wpp on 2017/3/7.
 */
public class Course {
    private int id;
    // 课程名称
    private String name;
    // 学分
    private int credit;
    // 创建时间
    private Date createTime;
    // 学期
    private int term;
    // 状态(0:废弃，1:生效)
    private int state;
    // 备注
    private String mark;

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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Course() {
    }

    public Course(int id, String name, int credit, int term, int state, String mark) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.term = term;
        this.state = state;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", createTime=" + createTime +
                ", term=" + term +
                ", state=" + state +
                ", mark='" + mark + '\'' +
                '}';
    }
}
