package LEETCODE;

import java.util.TreeSet;

/**
 * @program testCollections
 * @description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * @author: xielinzhi
 * @create: 2020/04/24 17:21
 */

public class LeetCode51 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length<=1) return 0;
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[j]<nums[i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
