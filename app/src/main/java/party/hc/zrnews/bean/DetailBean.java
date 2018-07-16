package party.hc.zrnews.bean;

import java.util.List;

/**
 * Created by QY on 2018/7/15.
 */

public class DetailBean {
    private String newsId;
    private String likeNum;
    private List<CommentBean> cbl;

    public String getNewsId() {
        return newsId;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public List<CommentBean> getCbl() {
        return cbl;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public void setCbl(List<CommentBean> cbl) {
        this.cbl = cbl;
    }

    public int getCommentNum(){
        return cbl.size();
    }
}
