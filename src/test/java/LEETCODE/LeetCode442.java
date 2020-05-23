package LEETCODE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @program testCollections
 * @description:
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: xielinzhi
 * @create: 2020/05/19 17:39
 */

public class LeetCode442 {

    //垃圾解法：因为值小于长度，可以用下标来做

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> returnList = new ArrayList<>(nums.length);
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(numSet.contains(nums[i])){
                returnList.add(nums[i]);
            }else {
                numSet.add(nums[i]);
            }
        }
        return returnList;
    }
}
