package Dao;

import Entity.User;
import Util.App;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class UserDao {

    public User getUser(String j_username, String j_password) throws IOException, NoSuchAlgorithmException {
        if (App.cookies == null) {
            App.cookies = App.getCookies(j_username, j_password);
        }
        JSONObject info = App.getinfo(App.cookies);
        User user = new User();
        user.setId(info.getString("id"));
        user.setXm(info.getString("xm"));
        user.setXb(info.getString("xb"));
        user.setKq(info.getString("kq").replaceAll("\\d+", ""));
        user.setXsm(info.getString("xsm"));
        user.setZym(info.getString("zym"));
        user.setCsrq(info.getString("csrq"));
        user.setBm(info.getString("bm"));
        user.setRxrq(info.getString("rxrq"));
        return user;
    }
}
