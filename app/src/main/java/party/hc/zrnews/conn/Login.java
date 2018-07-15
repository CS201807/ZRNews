package party.hc.zrnews.conn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import party.hc.zrnews.bean.UserBean;

/**
 * Created by QY on 2018/7/15.
 */

public class Login {
    private static String path;

    public static String login(String data, UserBean userBean) throws JSONException{

        String str = HttpUtil.postHttpRequset(path,data);

        if (str.equals("NotFound") ){
            return str;
        }else if (str.equals("WrongPassword")){
            return str;
        }else {
            JSONObject json = new JSONObject(str);
            JSONObject result = json.getJSONObject("result");
            JSONArray array = result.getJSONArray("data");

            for (int i = 0; i < array.length(); i++) {
                JSONObject temp = array.getJSONObject(i);
                userBean.setId(temp.optString("id"));
                userBean.setName(temp.optString("name"));
                userBean.setAvatar(temp.optString("avatar"));
            }
            str = "OK";
        }
        return str;
    }

}
