package LEETCODE;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program testCollections
 * @description: 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * @author: xielinzhi
 * @create: 2019/11/21 17:14
 */

/**
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class 计算各个位数不同的数字个数 {

    @Test
    public void testMain(){
        int n = 3;
        System.out.println(betterCount(n));
    }

    int betterCount(int n){
        int returnNum = 1;
        int [] dp;
        if(n<=10){
            dp = new int[n];
        }else {
            dp = new int[10];
        }

        if(n >= 1){
            dp[0] = 10;
            returnNum = dp[0];
        }
        if(n >= 2){
            dp[1] = 81;
            returnNum+=dp[1];
        }
        if(n>=3){
            for (int i = 2; i < n; i++) {
                if(i<10){
                    dp[i] = dp[i-1] *(10-i);
                    returnNum+=dp[i];
                }else {
                    break;
                }
            }
        }
        return returnNum;
    }
    int count(int n){
        //拆数字 算出
        double max = Math.pow(10,n);
        Double maxNum = Double.valueOf(max);
        List<Integer> temp = new ArrayList<>(n);
        int num = 0;
        temp.add(-1);
        int index;
        while (max-- > 0){
            index = 0;
            while ( temp.get(index)>=9){
                temp.set(index,0);
                index++;
                if(index>=temp.size()){
                    break;
                }
            }
            if(index>temp.size()-1){
                temp.add(0);
            }
            temp.set(index,temp.get(index)+1);
            Set<Integer> hashSet = new HashSet<>(temp);
            if(hashSet.size()<temp.size()){
                num++;
            }
        }

        return maxNum.intValue()-num;
    }


}
