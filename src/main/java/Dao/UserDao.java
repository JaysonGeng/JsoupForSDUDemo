package Dao;

import Entity.User;
import Util.App;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class UserDao {

    public User getUser(String cookies) throws IOException, NoSuchAlgorithmException {

        JSONObject info = App.getinfo(cookies);
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
