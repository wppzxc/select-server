package my.select.netData.down.course;

import my.select.entity.Course;

/**
 * Created by wpp on 2017/5/15.
 */
public class NetCourse {
    private int id;
    private String name;

    public NetCourse() {
    }

    public NetCourse(Course course) {
        this.id = course.getId();
        this.name = course.getName();
    }

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
}
