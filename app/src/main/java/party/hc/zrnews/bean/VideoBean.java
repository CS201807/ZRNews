package party.hc.zrnews.bean;

import java.io.Serializable;

/**
 * Created by QY on 2018/7/16.
 */

public class VideoBean implements Serializable {

    private String title;
    private String url;
    private String cover;

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getCover() {
        return cover;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
