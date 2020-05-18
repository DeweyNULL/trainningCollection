package LEETCODE;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/24 09:49
 */

public class 最长上升子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void  testLongest(){
        int [] nums = {1,1,4,4,1,3};
        System.out.println(lengthOfLIS(nums));
    }
}
