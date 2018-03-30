package Dao;

import Entity.Table;
import Entity.User;
import Util.App;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class TableDao {
    ArrayList<JSONObject> jtable =new ArrayList<JSONObject>();
    public ArrayList<JSONObject> getTable(String cookies) throws IOException, NoSuchAlgorithmException {

        String tables = App.getTable(cookies);
        Document doc = Jsoup.parse(tables);
        // 根据id获取table
        Element table = doc.getElementById("ysjddDataTableId");

        Elements trs = table.select("tr");
        String[] header={"序号","课程号","课程名称","课序号","学分","课程属性"
                ,"开课学院","任课教师","上课周次","上课星期","上课节次","上课地点"};
        for (int i = 0; i < trs.size(); ++i) {

            Element tr = trs.get(i);
            Elements tds = tr.select("td");
            JSONObject temp =new JSONObject();
            for (int j = 0; j < tds.size(); ++j) {
                Element td = tds.get(j);
                String text = td.text();
                temp.put(header[j],text);
//                System.out.println(temp);
            }
            jtable.add(temp);
        }

        return jtable;
    }
}
