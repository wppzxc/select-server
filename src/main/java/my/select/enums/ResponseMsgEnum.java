package my.select.enums;

/**
 * Created by wpp on 2017/4/29.
 */
public enum ResponseMsgEnum {

    UNDEFINE(-1,"未定义！","undefine msg"),
    OK(0,"","normal"),
    SUCCESS(1,"操作成功！","opt success!"),
    REQ_ERR(2,"失败！请求参数异常！","request error!"),
    INNER_ERR(3,"失败！服务器异常！","inner error!"),
    LOGOUT(4,"登出成功！","logout success!"),
    TIMEOUT(5,"登录超时！","login timeout!"),
    LOGIN(6,"登录成功！","login success!"),
    NO_COUNT_ERROR(7,"选课失败，没有名额！","no count to choose!"),
    REPEAT_CHOOSE_ERROR(8,"选课失败，您已选择该课程！","repeat error!"),
    DUPLICATION_DATA(9,"操作失败，数据重复！","duplication data!"),
    NO_PRIVILEGE(10,"请求失败，您没有权限！","no privilege!"),
    ;
    private int id;
    private String msg;
    private String comment;

    ResponseMsgEnum(int id, String msg, String comment) {
        this.id = id;
        this.msg = msg;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
