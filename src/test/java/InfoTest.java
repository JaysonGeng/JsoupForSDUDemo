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

        UserDao userDao =new UserDao();

        User user =userDao.getUser(j_username,j_password);
        System.out.println(user);
    }
}
