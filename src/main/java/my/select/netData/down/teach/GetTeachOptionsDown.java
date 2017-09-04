package my.select.netData.down.teach;

/**
 * Created by wpp on 2017/5/14.
 */
public class GetTeachOptionsDown {
    private int teachId;
    private String username;
    private String courseName;

    public int getTeachId() {
        return teachId;
    }

    public void setTeachId(int teachId) {
        this.teachId = teachId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "GetTeachOptionsDown{" +
                "teachId=" + teachId +
                ", username='" + username + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
