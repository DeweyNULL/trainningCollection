package LEETCODE;

import org.junit.Test;

import java.util.*;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/28 10:12
 */

public class LeetCode56_1 {
    public int[] singleNumbers(int[] nums) {
        Map<Integer,Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(tempMap.get(nums[i] )== null){
                tempMap.put(nums[i],1);
            }else {
                tempMap.put(nums[i] ,tempMap.get(nums[i])+1);
            }
        }

        Set<Integer> keys = tempMap.keySet();
        List<Integer> tempLists = new ArrayList<>(nums.length);
        int index = 0;
        for (Integer key: keys) {
            if(tempMap.get(key) == 1){
                tempLists.add(key);
            }
        }
        int[] returnArr = new int[tempLists.size()];
        for (int i = 0; i < tempLists.size(); i++) {
            returnArr[i] = tempLists.get(i);
        }
        return returnArr;
    }

    @Test
    public void testArr(){
        int [] nums = {4,1,4,6};
        singleNumbers(nums);
    }
}
