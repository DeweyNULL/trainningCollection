package 算法题;

import org.junit.Test;

import java.util.HashMap;

/**
 * @program springbootcachedemo
 * @description: 第一个只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符
 * ,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 * @author: xielinzhi
 * @create: 2019/05/06 11:50
 */

public class SingleChar {

    public int FirstNotRepeatingChar(String str) {
        char temp[] = str.toCharArray();
        HashMap<String,Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < temp.length; i++) {
            String tempStr = String.valueOf(temp[i]);
            if(map.containsKey(tempStr)){
               int value = map.get(tempStr)+1;
               map.put(tempStr,Integer.valueOf(value));
            }else {
               map.put(tempStr,1) ;
               result = i;
            }
        }

        int value = map.get(String.valueOf(temp[result]));
        if(value!=1){
            return -1;
        }

        return result;

    }

    @Test
    public void testFindSingle(){
        String string = "asdasdasdbb";
        System.out.println(FirstNotRepeatingChar(string));
    }
}
