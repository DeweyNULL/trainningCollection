package 算法题;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author: xielinzhi
 * @create: 2019/05/09 10:20
 */

public class ReplaceBlank {
    public String replaceSpace(StringBuffer str) {

        int hasSpace = str.indexOf(" ");
        while(hasSpace >= 0){
            str.deleteCharAt(hasSpace);
            str.insert(hasSpace,"%20");
            hasSpace = str.indexOf(" ");
        }
        return str.toString();
    }

    @Test
    public void testSpace(){
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(stringBuffer));
    }
}
