package my.select.netData.up.course;

/**
 * Created by wpp on 2017/3/22.
 */
public class UpdateCourseUp {
    private int id;
    private String name;
    private int credit;
    private int term;
    private int state;
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

    @Override
    public String toString() {
        return "UpdateCourseUp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", term=" + term +
                ", state=" + state +
                ", mark='" + mark + '\'' +
                '}';
    }
}
