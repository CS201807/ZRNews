package party.hc.zrnews.conn;

import android.widget.RadioGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import java.util.Random;

import party.hc.zrnews.bean.NewsBean;

/**
 * Created by QY on 2018/7/13.
 */

public class GetNews {

    //传入参数newsbean类型

    public static void getNews(List<NewsBean> newsBeanList,String data) throws JSONException {

        String path = "http://115.159.205.152:8080/WebNews/DoMoreArticle";

        //发送http请求
        String message = "article_type=" + data +"&"+ "article_index=" + newsBeanList.size() + "&" + "article_num=" + 10;
        String str = HttpUtil.postHttpRequset(path,message);
        //获得返回数据
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
            if (newsBean.getThumbnail1().equals("null")|newsBean.getThumbnail2().equals("null")){
                newsBean.setUiType("1");
            }
            else{
                if(Math.random()>0.2)
                    newsBean.setUiType("3");
                else
                    newsBean.setUiType("1");
            }
            // newsBean.setUiType(temp.optString("ui_type"));
            newsBeanList.add(newsBean);

        }
    }
}


