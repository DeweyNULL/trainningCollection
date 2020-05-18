package LEETCODE;

import org.junit.Test;

/**
 * @program testCollections
 * @description: 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * @author: xielinzhi
 * @create: 2020/04/23 15:56
 */

public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) return 1;
        int len = nums.length;
        int max = 1;
        for (int i = 0; i < len; i++) {
            int tempLen = 1;
            for (int j = i+1; j < len; j++) {
                if(nums[i]<nums[j]){
                    tempLen++;
                    i++;
                    j=i;
                }else {
                    break;
                }
            }
            if(tempLen>max){
                max = tempLen;
            }
        }
        return max;
    }

    @Test
    public void testSolition(){
        int [] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);

    }
}
