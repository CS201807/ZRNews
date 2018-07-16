package party.hc.zrnews.conn;

import android.media.JetPlayer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import party.hc.zrnews.bean.CommentBean;
import party.hc.zrnews.bean.DetailBean;

/**
 * Created by QY on 2018/7/13.
 */

public class GetDetails {

    public static void getDetails(String string, DetailBean detailBean)  throws JSONException{
        String path = "";
        String str = HttpUtil.postHttpRequset(path,string);//地址，新闻id

        JSONObject json = new JSONObject(str);
        JSONObject result = json.getJSONObject("result");
        JSONObject newsId = result.getJSONObject("newsId");
        JSONObject likeNum = result.getJSONObject("likeNum");
        JSONArray array = result.getJSONArray("data");
        List<CommentBean> commentBeanList = new ArrayList<>();

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

    }

    public static boolean like(String newsId,String userId) throws JSONException{
        String data = "newsId=" + newsId + "&" + "userId=" +userId;
        String path = "";

        String str = HttpUtil.postHttpRequset(path,data);
        JSONObject json = new JSONObject(str);
        String result = json.getJSONObject("result").toString();
        if (result.equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean addComment(String newsId,String userId,String message ) throws JSONException{
        String data = "newsId=" + newsId + "&" + "userId=" +userId + "&" + "message=" + message;
        String path = "";

        String str = HttpUtil.postHttpRequset(path,data);
        JSONObject json = new JSONObject(str);
        String result = json.getJSONObject("result").toString();
        if (result.equals("OK")) {
            return true;
        } else {
            return false;
        }

    }

}
