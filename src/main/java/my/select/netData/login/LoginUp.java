package my.select.netData.login;

/**
 * Created by wpp on 2017/4/28.
 */
public class LoginUp {
    private String number;
    private String password;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUp{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
