package 算法题;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/03/24 12:19
 */

public class Class1716 {
    public int massage(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
      }
}
