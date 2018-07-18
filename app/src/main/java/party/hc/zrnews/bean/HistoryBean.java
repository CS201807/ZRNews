package party.hc.zrnews.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ubuntu on 18-7-18.
 */

public class HistoryBean implements Serializable {
    private String id;
    private String title;
    private String date;
    private String saveTime;
    private String author;
    private String url;
    private String thumbnail;

    public HistoryBean(String id, String title, String date, String saveTime, String author, String url, String thumbnail) {
        this.id = id;
        this.title = title;
        this.date = date;
        Date d = new Date();
       // System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        //System.out.println("格式化后的日期：" + dateNowStr);
        this.saveTime = dateNowStr;
        this.author = author;
        this.url = url;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
