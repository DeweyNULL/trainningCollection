package LEETCODE;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/30 15:52
 */


public class LeetCode0404 {

    boolean needBreak = false;
    boolean isBalance = true;
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public boolean isBalanced(TreeNode root) {
        findNext(root);
        return  isBalance;
    }


    public int findNext(TreeNode root){
        if(root == null) return 0;
        if(needBreak){
            return 0;
        }
        int left = findNext(root.left);
        int right = findNext(root.right);

        if(left == 0 && right == 0){

            return 1;
        }else if(left>right){
            if(left - right > 1){
                needBreak = true;
                isBalance = false;
            }else {
                return left+1;
            }
        }else if(right>left){
            if(right - left > 1){
                needBreak = true;
                isBalance = false;
            }else {
                return right+1;
            }
        }else {
            return right+1;
        }
        return 0;
    }



}
