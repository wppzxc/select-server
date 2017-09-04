package my.select.netData.up.course;

import my.select.netData.up.PageBase;

/**
 * Created by wpp on 2017/3/22.
 */
public class GetCourseUp extends PageBase{
    private String name;
    private Integer state;

    public GetCourseUp(){}

    public GetCourseUp(String name, Integer state) {
        this.name = name;
        this.state = state;
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
