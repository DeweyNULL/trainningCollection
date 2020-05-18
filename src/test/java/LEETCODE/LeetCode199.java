package LEETCODE;

import org.junit.Test;

import java.util.*;

/**
 * @program testCollections
 * @description: 二叉树 右视图
 * @author: xielinzhi
 * @create: 2020/04/22 16:31
 */

public class LeetCode199 {

    List<Integer> returnList = new ArrayList<>();
    Map<Integer,Integer> mark = new HashMap<>();
    private  int index = 0;

    public List<Integer> rightSideView(TreeNode root) {
        through(root,0);
        return returnList;
    }

    public void through(TreeNode node , int depth){
        if(node==null) return ;

        if(mark.get(depth) == null){
            returnList.add(node.val);
            mark.put(depth,node.val);
        }
        depth++;
        through(node.right,depth);
        through(node.left,depth);
        return ;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void teseMain() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String input = in.next();
            if(input == null || input.length() == 0){
                System.out.print("False");
                continue;
            }
            String arr = input.substring(1,input.length()-1);
            if( arr.length()<1){
                System.out.print("False");
                continue;
            }
            String[] stringArr = arr.split(",");
            if("null".equals(stringArr[0])){
                System.out.print("False");
                continue;
            }
            //建树
            TreeNode node = new TreeNode(Integer.valueOf(stringArr[0]));
            index++;
            buildTree(node,stringArr);
            rightSideView(node);
            System.out.println(returnList.toArray().toString());
            returnList.clear();
            index = 0;
        }
    }


    public void buildTree(TreeNode node ,String[] stringArr){
        if(index>=stringArr.length) return;
        if(node == null) return;

        if(!"null".equals(stringArr[index])){
            node.left = new TreeNode(Integer.valueOf(stringArr[index]));
        }
        index++;
        if(index>=stringArr.length) return;
        if(!"null".equals(stringArr[index])){
            node.right = new TreeNode(Integer.valueOf(stringArr[index]));
        }
        index++;
        buildTree(node.left,stringArr);
        buildTree(node.right,stringArr);
    }
}
