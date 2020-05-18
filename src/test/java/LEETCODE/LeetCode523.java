package LEETCODE;

import org.junit.Test;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/29 14:32
 */

public class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 1) return false;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] + nums[i];
            if(k == 0){
                if(dp[i] == 0){
                    return true;
                }
            }else if(dp[i]%k == 0){
                return true;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int tempInt = dp[i];
                if(j > 0){
                    tempInt -= dp[j-1];
                }
                if(k == 0){
                    if(tempInt == 0){
                        return true;
                    }
                }else if(tempInt % k == 0){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void testFind(){
        int []nums = {0,1,0};
        int k = 0;
        System.out.println(checkSubarraySum(nums,k));
    }
}
