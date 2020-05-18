package LEETCODE;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/26 22:21
 */

public class LeetCode46 {

    List<List<Integer>> consequnce = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length<1) return null;
        List<Integer> rest = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            rest.add(nums[i]);
        }
        handleString(rest,new ArrayList<>());
        return consequnce;
    }

    public  void handleString(List<Integer> rest ,List<Integer> out){
        if(rest == null || rest.size()<1) {
            List<Integer> tempConsequnce = new ArrayList<>(out.size());
            tempConsequnce.addAll(out);
            consequnce.add(tempConsequnce);
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
                out.add(rest.get(i)) ;
                List<Integer> nextRest = new ArrayList<>(rest.size());
                nextRest.addAll(rest);
                nextRest.remove(rest.get(i));
                handleString(nextRest,out);
                out.remove(rest.get(i));
        }
    }

    @Test
    public void testArr(){
        int []nums = {1,2,3};
        permute(nums);
        System.out.println(consequnce);
    }

}
