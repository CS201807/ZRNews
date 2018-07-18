package party.hc.zrnews.bean;

import java.io.Serializable;

/**
 * Created by QY on 2018/7/13.
 */

public class UserBean implements Serializable{

    private String id;
    private String name;
    private String avatar;
    private String followers;
    private String focus;
    private String phone;
    private String sex;
    private String birthday;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPhone() {
        return phone;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFocus() {
        return focus;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
