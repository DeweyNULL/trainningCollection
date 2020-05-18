package LEETCODE;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program testCollections
 * @description: 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * @author: xielinzhi
 * @create: 2020/04/23 13:51
 */

public class LeetCode0801 {
    public int waysToChange(int n) {
        int [] coins = {1,5,10,25};
        int [] dp = new int[n+1];

        for (int i = 0; i <= n ; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= n; j++) {
                if(j>=coins[i])
                    dp[j] = dp[i] + dp[j-coins[i]];
            }
        }

        return dp[n];
    }

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i*i <= n; i++) {
            list.add(i*i);
        }
        
        int [] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1]+1;
            for (Integer temp: list) {
                if(i>=temp){
                    dp[i] = Math.min(dp[i],dp[i-temp]+1);
                }
            }
        }
        return dp[n];
    }


    @Test
    public void testDp(){
        numSquares(12);
    }
}
