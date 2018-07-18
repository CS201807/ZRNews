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

    public static String signUp(String phone, String username,String psw) throws JSONException {
        String data = "phone=" + phone + "&" + "username=" + username + "&" + "password=" + psw + "&" + "sex=" + "" + "&" + "birthday=" + "" ;
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

    public static boolean UpdateUserInfo(UserBean userBean,String username,String sex,String birthday)throws JSONException{

         if (username.equals(""))
             username = userBean.getName();
         if (sex.equals(""))
             sex = userBean.getSex();
         if (birthday.equals(""))
             birthday = userBean.getBirthday();

        String data = "user_id=" + userBean.getId() +"&"+ "username=" + username +"&"+
                "type=" + "normal" +"&"+ "sex=" + sex +"&"+ "birthday=" +birthday;
        String path = "http://115.159.205.152:8080/WebNews/UpdateUserInfo";

        String str = HttpUtil.postHttpRequset(path, data);
        JSONObject json = new JSONObject(str);
        String status = json.getString("status");
        if (status.equals("true")) {
//            userBean.setId(json.getString("id"));
            userBean.setName(json.getString("username"));
//            userBean.setAvatar(json.getString("avatar"));
//            userBean.setFollowers(json.getString("followers"));
//            userBean.setFocus(json.getString("focus"));
            userBean.setSex(json.getString("sex"));
            userBean.setBirthday(json.getString("birthday"));
            return true;
        } else {
            return false;
        }
    }

    public static boolean UpdatePassword(UserBean userBean,String oldPsw,String newPsw)throws JSONException{

        String data = "user_id=" + userBean.getId() +"&"+ "type=" + "password" +"&"+ "origin_password=" + oldPsw +"&"+ "new_password=" +newPsw;
        String path = "http://115.159.205.152:8080/WebNews/UpdateUserInfo";

        String str = HttpUtil.postHttpRequset(path, data);
        JSONObject json = new JSONObject(str);
        String status = json.getString("status");
        if (status.equals("true")){
            return true;
        }else
            return false;
    }
}

