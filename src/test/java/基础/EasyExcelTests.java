package 基础;


import com.alibaba.excel.EasyExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author gcx
 * @date 2019/12/17
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PortalApp.class)
public class EasyExcelTests {

    private final static String PREFIX = "D:\\file\\需求文档\\农行POC\\3.8.1改进\\easyexcel\\";

    public static void main(String[] args) throws Exception {
        writeExcel(1000000);
    }


    private static String[][] readExcel(int num) throws FileNotFoundException {
        String filePath = PREFIX + "黑名单(" + num + ").xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        return null;
    }

    private static void writeExcel(int num) {
        String filePath = PREFIX + "黑名单(" + num + ").xlsx";
        EasyExcel.write(filePath).head(head("名单值", "名称", "来源", "维度", "备注", "状态", "失效时间")).sheet().doWrite(dataList(num));
    }

    private static List<List<String>> head(String... heads) {
        List<List<String>> list = new ArrayList<>();
        for (String head : heads) {
            list.add(Collections.singletonList(head));
        }
        return list;
    }

    private static List<List<Object>> dataList(int num) {
        List<List<Object>> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            List<Object> data = new ArrayList<>();
            data.add("TEST" + i);
            data.add("名称" + i);
            data.add("规则策略同步");
            data.add("客户");
            data.add("备注" + i);
            data.add(i % 2 == 0 ? "启用" : "禁用");
            data.add("2022-12-19 14:09:45");
            list.add(data);
        }
        return list;
    }


    private static void bigArray() {
        String[][] bigArray = new String[10000000][10];
        for (int i = bigArray.length - 1; i >= 0; i--) {
            for (int j = 0; j < bigArray[i].length; j++) {
                bigArray[i][j] = "123123123213213123213213231231231321";
            }
        }
        int i = 0;
    }
}
