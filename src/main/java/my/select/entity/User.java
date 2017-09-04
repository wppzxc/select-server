package my.select.entity;

import java.util.Date;

/**
 * Created by wpp on 2017/3/7.
 */
public class User {
    private long id;
    // 学号
    private String number;
    // 密码
    private String password;
    // 姓名
    private String name;
    // 性别
    private int sex;
    // 年龄
    private int age;
    // 籍贯
    private String nativePlace;
    // 电话
    private String phone;
    // 入学时间
    private Date joinTime;
    // 学院
    private String institute;
    // 专业
    private String major;
    // 头像地址
    private String photo;
    // 状态(0:停用,1:启用)
    private int state;
    // 备注
    private String mark;

    public User() {
    }

    public User(long id, String number, String password, String name, int sex, int age, String nativePlace, String phone, Date joinTime, String institute, String major, String photo, int state, String mark) {
        this.id = id;
        this.number = number;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.nativePlace = nativePlace;
        this.phone = phone;
        this.joinTime = joinTime;
        this.institute = institute;
        this.major = major;
        this.photo = photo;
        this.state = state;
        this.mark = mark;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        return "NetUser{" +
                "id=" + id +
                ", number=" + number +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", nativePlace='" + nativePlace + '\'' +
                ", phone='" + phone + '\'' +
                ", joinTime=" + joinTime +
                ", institute='" + institute + '\'' +
                ", major='" + major + '\'' +
                ", photo='" + photo + '\'' +
                ", state=" + state +
                ", mark='" + mark + '\'' +
                '}';
    }
}
