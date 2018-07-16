package party.hc.zrnews.conn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import party.hc.zrnews.bean.UserBean;


/**
 * Created by QY on 2018/7/16.
 */

public class User {

    public static String login(String account, String password, UserBean userBean) throws JSONException {
        String data = "username=" + account + "&" + "password" + password;
        String path = "";

        String str = HttpUtil.postHttpRequset(path, data);

        JSONObject json = new JSONObject(str);
        String result = json.getJSONObject("result").toString();
        if (result.equals("NotFound")) {
            return result;
        } else if (result.equals("WrongPassword")) {
            return result;
        } else {
            JSONArray array = json.getJSONArray("data");
            for (int i = 0; i < array.length(); i++) {
                JSONObject temp = array.getJSONObject(i);
                userBean.setId(temp.optString("id"));
                userBean.setName(temp.optString("name"));
                userBean.setAvatar(temp.optString("avatar"));
                userBean.setPhoneNum(temp.optString("phoneNum"));
            }
            return "OK";
        }
    }


    public static String register(String id, String psw, String name, String phoneNum) throws JSONException {
        String data = "id=" + id + "&" + "password=" + psw + "&" + "name=" + name + "&" + "phoneNum=" + phoneNum;
        String path = "";

        String str = HttpUtil.postHttpRequset(path, data);
        JSONObject json = new JSONObject(str);
        String result = json.getJSONObject("result").toString();
        if (result.equals("IDExisted")) {
            return result;
        } else if (result.equals("Wrong")) {
            return result;
        } else {
            return "OK";
        }
    }
}
