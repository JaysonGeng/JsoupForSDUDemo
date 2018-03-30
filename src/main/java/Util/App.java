package Util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

public class App {

    final static String login = "http://bkjws.sdu.edu.cn/b/ajaxLogin";
    final static String info = "http://bkjws.sdu.edu.cn/b/grxx/xs/xjxx/detail";
    final static String table = "http://bkjws.sdu.edu.cn/f/xk/xs/bxqkb";
    public static String cookies = null;

    public static String getCookies(String j_username, String j_password) throws IOException, NoSuchAlgorithmException {

        Response response = Jsoup.connect(login).method(Method.POST)
                .data("j_username", j_username, "j_password", md5(j_password))
                .ignoreContentType(true)
                .userAgent("Mozilla/5.0 (X11; Linux x86_64…) Gecko/20100101 Firefox/59.0")
                .header("Referer", "http://bkjws.sdu.edu.cn/").execute();
        cookies = response.cookies().toString();
        cookies = cookies.substring(cookies.indexOf("{") + 1, cookies.lastIndexOf("}"));
        System.out.println(cookies);
        return String.valueOf(cookies);
    }

    public static String goHttp(String url, String cookie) throws IOException, NoSuchAlgorithmException {
        Connection conn = Jsoup.connect(url);
        conn.header("Host", "bkjws.sdu.edu.cn");
        conn.header("Connection", "keep-alive");
        conn.userAgent("Mozilla/5.0 (X11; Linux x86_64…) Gecko/20100101 Firefox/59.0");
        conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.header("Accept-Language", "zh-CN,zh;q=0.8");
        conn.header("Cookie", cookie);
        conn.method(Method.GET);
        conn.ignoreContentType(true);
        Response response = conn.execute();
        String body = response.body();
        return body;
    }


    public static JSONObject getinfo(String cookie) throws IOException, NoSuchAlgorithmException {

        String infos = goHttp(info, cookie);
        JSONObject jsonObject = new JSONObject(infos);
        JSONObject infoss = null;
        if (jsonObject.getString("result").equals("success")) {
            infoss = jsonObject.getJSONObject("object");
        }
        return infoss;
    }

    public static String getTable(String cookie) throws IOException, NoSuchAlgorithmException {

        String tables = goHttp(table, cookie);
        return tables;
    }

    public static String md5(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] res = digest.digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            int val = res[i] & 0xff;
            if (val < 16)
                sb.append("0" + Integer.toHexString(val));
            else
                sb.append(Integer.toHexString(val));
        }
        return sb.toString();

    }
}