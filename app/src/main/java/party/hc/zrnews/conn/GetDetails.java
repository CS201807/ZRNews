package party.hc.zrnews.conn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import party.hc.zrnews.bean.CommentBean;
import party.hc.zrnews.bean.DetailBean;

/**
 * Created by QY on 2018/7/13.
 */

public class GetDetails {
    private String path;

    public void getDetails(String string, DetailBean detailBean)  throws JSONException{

        String str = HttpUtil.postHttpRequset(path,string);//地址，新闻id

        JSONObject json = new JSONObject(str);
        JSONObject result = json.getJSONObject("result");
        JSONObject newsId = result.getJSONObject("newsId");
        JSONObject likeNum = result.getJSONObject("likeNum");
        JSONArray array = result.getJSONArray("data");
        List<CommentBean> commentBeanList = null;

        for (int i = 0; i < array.length(); i++) {
            JSONObject temp = array.getJSONObject(i);
            CommentBean cb = new CommentBean();
            cb.setUserId(temp.optString("userId"));
            cb.setUserName(temp.optString("userName"));
            cb.setDate(temp.optString("date"));
            cb.setAvatar(temp.optString("avatar"));
            cb.setComment(temp.optString("comment"));
            commentBeanList.add(cb);

        }
        detailBean.setNewsId(newsId.toString());
        detailBean.setLikeNum(likeNum.toString());
        detailBean.setCbl(commentBeanList);

        str = "OK";

    }

}
