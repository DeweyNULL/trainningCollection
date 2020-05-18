package 基础;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2019/09/05 11:39
 */
class TestMap{


    public TestMap(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name ;
}
public class MapTest {

    Map<String,TestMap> map = new ConcurrentHashMap<>();

    @Test
    public void testHashMap(){
        Map<String,String> testMap = new HashMap<>();
        testMap.put("key1","test1");
        changeMapItem(testMap);
        System.out.println(testMap.get("key1"));
        System.out.println(testMap.get("key2"));
    }

    public void changeMapItem(Map<String,String> temp){
        temp.put("key1","test111");
        temp.put("key2","test2");
        temp.remove("key3");
    }

    @Test
    public void testMap(){
        init();
        Name name = new Name();
        name.setName(map.get("2").getName());
        map.clear();
        System.out.println(name.name);
        System.out.println(map.size());
    }

    void init(){
        map.put("1",new TestMap("1"));
        map.put("2",new TestMap("2"));
    }

    class Name{

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;
    }

    @Test
    public void testList(){
        List<Integer> temp = new ArrayList<>();
        temp.addAll(null);
    }
}
