package 算法题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @program springbootcachedemo
 * @description: 最长子串
 * @author: xielinzhi
 * @create: 2019/05/12 21:03
 */

public class JavaMaxSon {

    public void findmax(String temp){

        ArrayList<String> list = new ArrayList<>();
        String sub ;
        for (int i = 0; i < temp.length(); i++) {
            for (int j = i+1; j <= temp.length(); j++) {
                sub = temp.substring(i,j);
                if(unique(sub)){
                    list.add(sub);
                }
            }
        }

        int mark = 0;
        int len;
        int max;
        int num = 0;
        max = list.get(0).length();
        for (String substring: list) {
            System.out.println(substring);
            len = substring.length();
            if(len>max){
                mark = num;
                max = len;
            }
            num++;
        }

        System.out.println(max);
        System.out.println(mark);
        System.out.println(list.get(mark));
    }

    public boolean unique(String temp){
        HashSet<Character> set =  new HashSet<>();

        char []stringchar = temp.toCharArray();
        for (int i = 0; i < temp.length(); i++) {
            if(!set.contains(stringchar[i])){
                set.add(stringchar[i]);
            }else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        findmax("bbbbbb");
    }
}
