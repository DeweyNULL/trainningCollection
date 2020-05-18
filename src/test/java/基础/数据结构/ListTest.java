package 基础.数据结构;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program springbootcachedemo
 * @description: 测试集合
 * @author: xielinzhi
 * @create: 2019/06/25 13:39
 */

public class ListTest {

    @Test
    public void testList(){
        Map<String,Object> testMap = new HashMap<>();
        List<Object> temp = new ArrayList<>();
        temp.add("0");
        Map<String,String> tempMap = new HashMap<>();
        tempMap.put("1","2");
        tempMap.put("2","3");
        temp.add(tempMap);
        testMap.put("list",temp);

        temp = (List<Object>) testMap.get("list");
        temp.add(1);

        for (Map.Entry map: testMap.entrySet()) {

        }

    }

    @Test
    public void testPartition(){
        List<Integer> integers = new ArrayList<>();
        for (int i = 0 ; i < 10; i ++){
            integers.add(i);
        }
        List< List<Integer>> returnList= partition(integers,5);
        System.out.println(returnList.size());
        System.out.println(splitList(integers,5).size());
    }

    public  <T> List<List<T>> partition(List<T> list, int partition) {
        List<List<T>> lists = new ArrayList<List<T>>();
        if (list == null || list.size() < 2 || partition < 2) {
            lists.add(list);
        } else {
            int oSize = list.size();
            int batch = oSize / partition;
            // 最小批处理量为1.
            batch = batch <= 0 ? 1 : batch;
            int index = 0;
            int endIndex = 0;
            for (int i = 0; i < partition - 1 && index < oSize; ++i) {
                endIndex = Math.min(list.size(), index + batch);
                lists.add(list.subList(index, endIndex));
                index += endIndex - index;
            }
            if (index < oSize) {
                lists.add(list.subList(index, oSize));
            }
        }
        return lists;
    }

    public  <T> List<List<T>> splitList(List<T> list, int commitSize) {
        List<List<T>> splistList = new ArrayList<List<T>>();
        if (list == null || list.isEmpty()) {
            return splistList;
        }
        int range = commitSize;
        if (list.size() < range) {
            splistList.add(list);
            return splistList;
        }
        int size = list.size();
        int num = size % range == 0 ? size / range : (size / range) + 1;
        for (int j = 0; j < num; j++) {
            int beg = range * j;
            int end = range * j + range;
            if ((j + 1) == num) {
                end = size;
            }
            splistList.add(list.subList(beg, end));
        }
        return splistList;
    }

    @Test
    public void testSame(){
        List<Integer> temp = new ArrayList<>(100);

        for (Integer tempInt: temp ) {
            System.out.println("hi");
        }

    }
}
