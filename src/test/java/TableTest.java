import Dao.TableDao;
import Util.App;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class TableTest {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        /**
         * 这是登录的学号和密码
         * */
        String j_username = "2017xxxxxxxxx";
        String j_password = "123456";

        TableDao tableDao = new TableDao();
        if (App.cookies == null) {
            App.cookies = App.getCookies(j_username, j_password);
        }
        if (!App.cookies.equals("xe0001")) {

            ArrayList<JSONObject> tables = tableDao.getTable(App.cookies);
            String[] header = {"序号", "课程号", "课程名称", "课序号", "学分", "课程属性"
                    , "开课学院", "任课教师", "上课周次", "上课星期", "上课节次", "上课地点"};
            for (String s : header) {
                System.out.print(s + "\t");
            }
            System.out.println();
            for (JSONObject j : tables) {
                if (!j.toString().equals("{}")) {
                    for (int i = 0; i < 12; i++) {
                        System.out.print(j.getString(header[i]) + "\t");

                    }
                }
                System.out.println();
            }
        }
    }
}
