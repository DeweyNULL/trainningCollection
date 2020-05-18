import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/24 19:35
 */

public class LeetCodeHW {

    int len = 0;
    public void find ( String rest,String out){
        if(rest == null || rest.length()<1) {
            //输出字符串
            System.out.println(out);
            return;
        }
        for (int i = 0; i < rest.length(); i++) {
            out+=rest.charAt(i);
            find(rest.substring(0,i) + rest.substring(i+1),out);
            out = out.substring(0,len - rest.length());
        }
    }
    @Test
    public void test(){
        String testString = "adbc";
        len = testString.length();
        find(testString,"");

    }

}
