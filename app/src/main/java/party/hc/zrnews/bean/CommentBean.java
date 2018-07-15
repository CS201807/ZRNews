package party.hc.zrnews.bean;

/**
 * Created by QY on 2018/7/15.
 */

public class CommentBean {
    private String userId;
    private String userName;
    private String avatar;
    private String date;
    private String comment;


    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
