package LEETCODE;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/30 15:14
 */

public class LeetCode202 {
    public boolean isHappy(int n) {
        while (true){
            int sum = count(n);
            if(sum == 1){
                return true;
            }else if(sum == 4){
                return false;
            }
            n = sum;
        }
    }

    public int count(int n){
        Integer temp = n;
        String numbers = temp.toString();
        int len = numbers.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int tempNum  = Integer.valueOf(numbers.charAt(i)+"");
            sum += (tempNum * tempNum);
        }
        return sum;
    }
}
