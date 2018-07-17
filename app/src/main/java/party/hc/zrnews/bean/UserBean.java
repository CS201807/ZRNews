package party.hc.zrnews.bean;

/**
 * Created by QY on 2018/7/13.
 */

public class UserBean {

    private String id;
    private String name;
    private String avatar;
    private String followers;
    private String focus;
    private String phoneNum;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFocus() {
        return focus;
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

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }
}
