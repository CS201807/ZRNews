package party.hc.zrnews.conn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import party.hc.zrnews.bean.VideoBean;

/**
 * Created by QY on 2018/7/16.
 */

public class GetVideos {

    private static String path = "http://115.159.205.152:8080/WebNews/DoVideo";

    public static void getVideos(List<VideoBean> videoBeanList) throws JSONException {

        String str = HttpUtil.sendHttpRequset(path);
        //获得返回数据
        JSONObject json = new JSONObject(str);
        JSONArray array = json.getJSONArray("data");

        for (int i = 0; i < array.length(); i++) {
            JSONObject temp = array.getJSONObject(i);
            VideoBean videoBean = new VideoBean();
            videoBean.setTitle(temp.optString("title"));
            videoBean.setUrl(temp.optString("url"));
            videoBean.setCover(temp.optString("cover"));
            videoBeanList.add(videoBean);
        }
    }


}
