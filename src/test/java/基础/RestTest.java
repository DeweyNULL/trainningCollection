package 基础;

import org.junit.Test;
import org.mockito.cglib.core.CollectionUtils;

import java.sql.ResultSet;
import java.util.*;

/**
 * @program testCollections
 * @description: 测试
 * @author: xielinzhi
 * @create: 2019/09/18 21:18
 */

public class RestTest {

    @Test
    public void testRes() throws Exception{
        ResultSet res = null;
    }

    @Test
    public void testString() throws Exception{
        System.out.println(String.valueOf(null));
    }

    @Test
    public void testStringList() throws Exception{
        String items = "";
        List<String> listIds = Arrays.asList(items.split(","));
        System.out.println(listIds.size());
    }

    @Test
    public void testString1(){
        String[] name_arr = "12,22,33,44".split(",");
        List list = new ArrayList();
        System.out.println(name_arr[0].trim());
    }

    @Test
    public void testTime(){
        for (int i = 0; i < 100000; i++) {
            Date time = new Date();
            System.out.println(time.getTime());
        }
    }

    @Test
    public void testTime2(){
        for (int i = 0; i < 100000; i++) {
            Date time =new Date(System.currentTimeMillis());
            System.out.println(time.getTime());
        }
    }
}
