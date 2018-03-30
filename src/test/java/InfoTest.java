import Dao.UserDao;
import Entity.User;
import Util.App;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class InfoTest {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        /**
         * 这是登录的学号和密码
         * */
        String j_username = "2017xxxxxxxxx";
        String j_password = "123456";

        UserDao userDao = new UserDao();
        if (App.cookies == null) {
            App.cookies = App.getCookies(j_username, j_password);
        }
        if (!App.cookies.equals("xe0001")) {
            User user = userDao.getUser(App.cookies);
            System.out.println(user);
        }
    }
}
