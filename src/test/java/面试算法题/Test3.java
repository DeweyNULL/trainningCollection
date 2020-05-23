package 面试算法题;

/**
 * @program testCollections
 * @description:
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 *
 * @author: xielinzhi
 * @create: 2020/05/18 19:40
 */

public class Test3 {

    public boolean kLengthApart(int[] nums, int k) {

        if(nums.length == 1){
            if(nums[0] == 0) return false;
            else {
                if(k == 0) return true;
            }
        }
        int mark = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                if(mark<0){
                    mark = i;
                    continue;
                }
                if(i-mark<=k){
                    return false;
                }
                mark = i;
            }
        }
        return true;
    }

}
