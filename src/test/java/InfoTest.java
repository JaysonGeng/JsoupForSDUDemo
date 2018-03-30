import Dao.UserDao;
import Entity.User;
import Util.App;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class InfoTest {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        /**
         * 这是登录的学号和密码
         * */
        Properties prop = new Properties();
        prop.load(TableTest.class.getResourceAsStream("/UserInfo.properties"));
        String j_username = prop.getProperty("j_username");
        String j_password = prop.getProperty("j_password");

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
