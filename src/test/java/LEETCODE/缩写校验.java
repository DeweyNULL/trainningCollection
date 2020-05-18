package LEETCODE;

import org.junit.Test;

/**
 * @program testCollections
 * @description: 缩写校验
 * @author: xielinzhi
 * @create: 2020/04/02 21:53
 */

public class 缩写校验 {
    boolean valid(String word,String abbr){
        if(abbr == null || abbr.length()<1){
            return false;
        }
        char[] original = word.toCharArray();
        char[] abbrArr = abbr.toCharArray();
        int index = 0;
        String num ="";
        for (int i = 0; i < abbrArr.length; i++) {
            //当前若是数字，判断下一个是否也是数字
            if(abbrArr[i]>='0' && abbrArr[i]<='9'){
                num = num + abbrArr[i];
                //如果下一个不是数字，就加index
                if( (i+1) < abbrArr.length && (abbrArr[i+1]<'0' || abbrArr[i+1]>'9')){
                    index += Integer.valueOf(num);
                    num = "";
                }else if(i+1 == abbrArr.length){
                    index += Integer.valueOf(num);
                    num = "";
                }
            }else {
                //判断当前字母是否与原字段字母相等
                if(abbrArr[i] != original[index++]){
                    return false;
                }
            }
            if(index>original.length){
                return false;
            }
        }
        return true;
    }

    @Test
    public  void test() {
        String[] test = {"word", "1ord", "w1rd", "wo1d","wor1", "2rd", "w2d",
                "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d","w3", "4"};
        for (String s : test) {
            System.out.println(valid("word", s));
        }
    }
}
