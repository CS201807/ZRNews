package party.hc.zrnews.bean;

import java.net.URL;

/**
 * Created by ubuntu on 18-7-11.
 */

public class NewsBean {
    public String getTitle() {
        return title;
    }

    private String title;

    public String getOpenUrl() {
        return openUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
    }

    private String openUrl;

    public NewsBean(String title, String openUrl) {
        this.title = title;
        this.openUrl = openUrl;
    }
}
