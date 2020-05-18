package LEETCODE;

import org.junit.Test;

/**
 * @program testCollections
 * @description: 山脉数组中查找目标值
 * @author: xielinzhi
 * @create: 2020/04/29 10:09
 */

public class LeetCode1095 {
    class MountainArray{
        int [] arr ;

        MountainArray(int[] arr){
            this.arr = arr;
        }
        public int  get(int index){
            try {
                return arr[index];
            }catch (Exception e){
                return Integer.MIN_VALUE;
            }
        }

        public int  length(){
            try {
                return arr.length;
            }catch (Exception e){
                return -1;
            }
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {

        if(mountainArr == null ) return -1;
        int len = mountainArr.length();
        if (len<3) return -1;

        //找到山顶
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left<=right){
             mid = left + (right - left) /2;
            int midNum = mountainArr.get(mid);
            if(mid == 0){
                if(midNum > mountainArr.get(mid+1)){
                    break;
                }else {
                    left = mid + 1 ;
                }
            }else if(mid == len - 1){
                if(midNum > mountainArr.get(mid-1)){
                    break;
                }else {
                    right = mid - 1;
                }
            }else {
                if(midNum > mountainArr.get(mid+1)){
                    if(midNum > mountainArr.get(mid -1)){
                        break;
                    }else {
                        right = mid - 1;
                    }
                }else {
                    left = mid + 1;
                }
            }
        }

        //遍历山顶之前的数组
        left = 0 ;
        right = mid;
        while (left<=right){
            int tempMid = left + (right - left) / 2;
            int tempMidNum =  mountainArr.get(tempMid);
            if(target == tempMidNum){
                return tempMid;
            }else if(target > tempMidNum){
                left = tempMid + 1;
            }else {
                right = tempMid - 1;
            }
        }

        left = mid ;
        right = len - 1;
        while (left<=right){
            int tempMid = left + (right - left) / 2;
            int tempMidNum =  mountainArr.get(tempMid);
            if(target == tempMidNum){
                return tempMid;
            }else if(target < tempMidNum){
                left = tempMid + 1;
            }else {
                right = tempMid - 1;
            }
        }
        return -1;
    }

    @Test
    public void testArr(){
        int [] nums = { 1, 5, 2 };
        System.out.println(findInMountainArray(2,new MountainArray(nums)));
    }
}
