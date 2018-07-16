package party.hc.zrnews.conn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.bean.UserBean;


/**
 * Created by QY on 2018/7/16.
 */

public class User {
    public String USER_ID;

    public User(String USER_ID) {this.USER_ID = USER_ID;
    }

    public void getLikeList(List<NewsBean> newsBeanList) throws JSONException {
        String data = "userId=" + USER_ID;
        String path = "";

        String str = HttpUtil.postHttpRequset(path, data);

        JSONObject json = new JSONObject(str);
        JSONArray array = json.getJSONArray("data");
        for (int i = 0; i < array.length(); i++) {
            JSONObject temp = array.getJSONObject(i);
            NewsBean newsBean = new NewsBean();
            newsBean.setId(temp.optString("uniquekey"));
            newsBean.setTitle(temp.optString("title"));
            newsBean.setDate(temp.optString("date"));
            newsBean.setCategory(temp.optString("category"));
            newsBean.setAuthor(temp.optString("author_name"));
            newsBean.setUrl(temp.optString("url"));
            newsBean.setThumbnail(temp.optString("thumbnail_pic_s0"));
            newsBean.setThumbnail1(temp.optString("thumbnail_pic_s1"));
            newsBean.setThumbnail2(temp.optString("thumbnail_pic_s2"));
            newsBean.setUiType(temp.optString("ui_type"));
            newsBeanList.add(newsBean);

        }
    }


    public void getHistoryList(List<NewsBean> newsBeanList) throws JSONException {
        String data = "userId=" + USER_ID;
        String path = "";

        String str = HttpUtil.postHttpRequset(path, data);

        JSONObject json = new JSONObject(str);
        JSONArray array = json.getJSONArray("data");
        for (int i = 0; i < array.length(); i++) {
            JSONObject temp = array.getJSONObject(i);
            NewsBean newsBean = new NewsBean();
            newsBean.setId(temp.optString("uniquekey"));
            newsBean.setTitle(temp.optString("title"));
            newsBean.setDate(temp.optString("date"));
            newsBean.setCategory(temp.optString("category"));
            newsBean.setAuthor(temp.optString("author_name"));
            newsBean.setUrl(temp.optString("url"));
            newsBean.setThumbnail(temp.optString("thumbnail_pic_s0"));
            newsBean.setThumbnail1(temp.optString("thumbnail_pic_s1"));
            newsBean.setThumbnail2(temp.optString("thumbnail_pic_s2"));
            newsBean.setUiType(temp.optString("ui_type"));
            newsBeanList.add(newsBean);

        }
    }

}
