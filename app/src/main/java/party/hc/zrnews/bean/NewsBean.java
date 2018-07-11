package party.hc.zrnews.bean;

/**
 * Created by ubuntu on 18-7-11.
 */

public class NewsBean {
    public String getTitle() {
        return title;
    }

    private String title;

    public NewsBean(String title) {
        this.title = title;
    }
}
