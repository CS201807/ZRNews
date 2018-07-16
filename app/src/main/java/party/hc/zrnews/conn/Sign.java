package party.hc.zrnews.conn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import party.hc.zrnews.bean.UserBean;

/**
 * Created by QY on 2018/7/16.
 */

public class Sign {

    public static String signIn(String account, String password,UserBean userBean) throws JSONException{

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
            JSONObject jdata = json.getJSONObject("data");
            userBean.setId(jdata.getJSONObject("id").toString());
            userBean.setName(jdata.getJSONObject("name").toString());
            userBean.setAvatar(jdata.getJSONObject("avatat").toString());
            userBean.setPhoneNum(jdata.getJSONObject("phoneNum").toString());

            return "OK";
        }
    }

    public String signUp(String id, String psw, String name, String phoneNum) throws JSONException {
        String data = "id=" + id + "&" + "password=" + psw + "&" + "name=" + name + "&" + "phoneNum=" + phoneNum;
        String path = "";

        String str = HttpUtil.postHttpRequset(path, data);
        JSONObject json = new JSONObject(str);
        String result = json.getJSONObject("result").toString();
        if (result.equals("IDExisted")) {
            return result;
        } else if (result.equals("OK")) {
            return result;
        } else {
            return "RegisterFailed";
        }
    }
}
