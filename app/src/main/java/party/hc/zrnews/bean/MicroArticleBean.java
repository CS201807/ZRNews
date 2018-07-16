package party.hc.zrnews.bean;

import java.util.List;

/**
 * Created by ubuntu on 18-7-16.
 */

public class MicroArticleBean {
    private List<String> pics;

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTime(String time) {
        Time = time;
    }

    public List<String> getPics() {
        return pics;
    }

    public String getContent() {
        return content;
    }

    public String getHeadPic() {
        return headPic;
    }

    public String getUserName() {
        return userName;
    }

    public String getTime() {
        return Time;
    }

    private String content;
    private String headPic;
    private String userName;
    private String Time;

}
