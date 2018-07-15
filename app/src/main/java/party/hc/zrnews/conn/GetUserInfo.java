package party.hc.zrnews.conn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.bean.UserBean;

/**
 * Created by QY on 2018/7/13.
 */

public class GetUserInfo {
    private static String path;


    //传入参数 userbean类型
    public static void getUserInfo(UserBean userBean) throws JSONException {

        //发送请求
        String str = HttpUtil.sendHttpRequset(path);
        //获取返回数据
        JSONObject json = new JSONObject(str);
        JSONObject result = json.getJSONObject("result");
        JSONArray array = result.getJSONArray("data");

        for (int i = 0; i < array.length(); i++) {
            JSONObject temp = array.getJSONObject(i);
            userBean.setId(temp.optString("id"));
            userBean.setName(temp.optString("name"));
            userBean.setAvatar(temp.optString("avatar"));
        }
    }

}
