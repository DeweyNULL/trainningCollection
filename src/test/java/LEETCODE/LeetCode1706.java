package LEETCODE;

import org.junit.Test;

/**
 * @program testCollections
 * @description: 2出现的次数
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * @author: xielinzhi
 * @create: 2020/05/18 19:58
 */

public class LeetCode1706 {
    public int numberOf2sInRange(int n) {
        Integer numebr = n;
        String numberStr = numebr.toString();
        double [] nums = new double[numberStr.length()];
        nums[0] = 1;
        for (int i = 1; i < numberStr.length() - 1 ; i++) {
            nums[i] = nums[i-1] * 10 + Math.pow(10,i);
        }
        int ans = 0;
        for (int i =  0 ; i < numberStr.length() ; i++) {
            if(numberStr.charAt(i) <  '2' ){
                ans = ans + (int)nums[numberStr.length() - i - 1] * Integer.valueOf(numberStr.charAt(i));
            }else if(numberStr.charAt(i) > '2'){
                ans = ans + (int)nums[numberStr.length() - i - 2] * Integer.valueOf(numberStr.charAt(i));
            }else {
                ans = ans + (int)nums[numberStr.length() - i - 1] * Integer.valueOf(numberStr.charAt(i));
            }
        }
        return 0;
    }

    @Test
    public void test(){
        numberOf2sInRange(100);
    }
}
