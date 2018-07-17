package party.hc.zrnews.conn;

import org.json.JSONException;
import org.json.JSONObject;

import party.hc.zrnews.bean.UserBean;

/**
 * Created by QY on 2018/7/16.
 */

public class Sign {

    public static String signIn(String account, String password, UserBean userBean) throws JSONException {

        String data = "phone=" + account + "&" + "password=" + password;
        String path = "http://115.159.205.152:8080/WebNews/DoLogin";

        String str = HttpUtil.postHttpRequset(path, data);
        JSONObject json = new JSONObject(str);
        String status = json.getString("status");
        if (status.equals("true")) {
            userBean.setId(json.getString("id"));
            userBean.setName(json.getString("username"));
            userBean.setAvatar(json.getString("avatar"));
            userBean.setFollowers(json.getString("followers"));
            userBean.setFocus(json.getString("focus"));
            userBean.setSex(json.getString("sex"));
            userBean.setBirthday(json.getString("birthday"));
            return "OK";
        } else {
            return json.getString("reason");
        }
    }

    public String signUp(String phone,String psw, String username) throws JSONException {
        String data = "phone=" + phone + "&" + "username=" + username + "&" + "password=" + psw ;
        String path = "http://115.159.205.152:8080/WebNews/SignUp";

        String str = HttpUtil.postHttpRequset(path, data);
        JSONObject json = new JSONObject(str);
        String status = json.getString("status");
        if (status.equals("true")) {
            return "OK";
        } else {
            return json.getString("reason");
        }
    }
}

