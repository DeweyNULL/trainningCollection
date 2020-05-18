package huawei;

/**
 * @program testCollections
 * @description: 华为题目
 * @author: xielinzhi
 * @create: 2020/04/21 20:31
 */

public class JavaTest {
    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public int partition (String s) {
        // write code here
        if(s .length() == 1){
            return  1;
        }
        return 0;
    }

    public boolean isRight(String s){

        if(s!=null && s.length() == 1) return true;
        if(s == null) return false;
        int left = 0 ;
        int right = s.length() -1 ;
        while ( left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
