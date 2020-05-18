package LEETCODE;

/**
 * @program testCollections
 * @description: 买股票 with colddown
 * @author: xielinzhi
 * @create: 2020/04/23 17:34
 */

public class LeetCode309 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length<1) return 0;

        int [][] dp = new int[prices.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i <prices.length ; i++) {
            if(i == 1){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] =  Math.min(dp[i-1][1],-prices[1]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] =  Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }

        return dp[prices.length-1][0];
    }

}
