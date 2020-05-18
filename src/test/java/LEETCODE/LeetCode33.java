package LEETCODE;

import org.junit.Test;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/27 09:50
 */

public class LeetCode33 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length <1) return -1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (target < nums[mid]){
                if(mid == left){
                    left = mid+1;
                    continue;
                }
                if(nums[mid]>nums[left]){
                    if(target>=nums[left]){
                        right = mid -1;
                    }else {
                        left = mid+1;
                    }
                }else {
                    right = mid -1;
                }
            }else if (target > nums[mid]){
                //没旋转
                if(mid == 0){
                    left = mid+1;
                    continue;
                }
                if(nums[left]<nums[right]){
                    left = mid+1;
                }else {
                    if(target>= nums[left]){
                        if(nums[mid] > nums[left]){
                            left = mid + 1;
                        }else {
                            right = mid -1;
                        }
                    }else {
                        left = mid + 1;
                    }
                }
            }else if(target == nums[mid]){
                return mid;
            }

        }
        return -1;
    }

    @Test
    public void testSearch(){

        int [] nums6 = {4,5,6,7,0,1,2};
        System.out.println(search(nums6,0));
        int[] nums5 ={6,7,1,2,3,4,5};
        System.out.println(search(nums5,6));
      int []  nums = {4,5,6,7,8,1,2,3};
      System.out.println(search(nums,8));
      int []  nums2 = {5,1,3};
      System.out.println(search(nums2,3));

       int []  nums3 = {1,3};
       System.out.println(search(nums3,3));
        int []  nums4 = {5,1,3};
        System.out.println(search(nums4,5));


    }
}
