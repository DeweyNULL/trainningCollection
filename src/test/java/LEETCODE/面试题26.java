package LEETCODE;

import org.junit.Test;

/**
 * @program testCollections
 * @description:
 *  输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *  B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @author: xielinzhi
 * @create: 2020/05/19 17:54
 */

public class 面试题26 {

    boolean isSub = false;
    int nums = 0;
    int tmpNums = 0;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null){
            return isSub;
        }
        treeNodeNums(B);
        treeThread(A,B);
        return isSub;
    }
    public void treeNodeNums(TreeNode tree){
        if(tree == null) return;
        nums++;
        treeNodeNums(tree.left);
        treeNodeNums(tree.right);
    }
    public void treeThread(TreeNode A,TreeNode B){

        if( isSub || A == null){
            return;
        }
        if(A.val == B.val){
            compare(A,B);
            tmpNums = 0;
        }
        treeThread(A.left,B);
        treeThread(A.right,B);
    }

    public void compare(TreeNode A,TreeNode B){
        if(isSub){
            return;
        }
        if(B == null){
            if(tmpNums == nums){
                isSub = true;
            }
            return;
        }
        if(A == null && B != null) return;
        if(A.val == B.val){
            tmpNums++;
            compare(A.left,B.left);
            compare(A.right,B.right);
        }
    }


    class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    @Test
    public void testMain(){
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(4);
        head.right = new TreeNode(5);
        TreeNode left = head.left;
        left.left = new TreeNode(1);
        left.right = new TreeNode(2);

    }
}
