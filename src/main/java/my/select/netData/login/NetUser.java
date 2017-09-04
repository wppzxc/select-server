package my.select.netData.login;

import my.select.entity.User;

/**
 * Created by wpp on 2017/4/28.
 */
public class NetUser {
    private long id;
    private String number;
    private String name;
    private String photo;
    private String token;

    public NetUser() {
    }

    public NetUser(User user) {
        this.id = user.getId();
        this.number = user.getNumber();
        this.name = user.getName();
        this.photo = user.getPhoto();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
