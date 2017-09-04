package my.select.enums;

/**
 * Created by wpp on 2017/5/15.
 */
public enum GeneralStateEnum {
    UNDEFINE(-1,"undefine!"),
    OFF(0,"off state"),
    ON(1,"on state"),
    ;

    GeneralStateEnum(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    private int id;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
