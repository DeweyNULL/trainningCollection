package LEETCODE;

import org.junit.Test;

/**
 * @program testCollections
 * @description: 统计优美子数组
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: xielinzhi
 * @create: 2020/04/24 10:23
 */

public class LeetCode1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        if( nums == null || nums .length<1) return count;

        int len = nums.length;
        for (int i = 0; i < len ; i++) {
            int tempK = 0;
            for (int j = i; j < len; j++) {
                if(nums[j] %2 == 1){
                    tempK ++;
                }
                if(tempK>k){
                    break;
                }else if(tempK == k){
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void testArr(){
        int [] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums,k));
    }
}
