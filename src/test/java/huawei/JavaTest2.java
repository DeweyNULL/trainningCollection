package huawei;

import java.util.*;

/**
 * @program testCollections
 * @description: 二叉搜索树
 * @author: xielinzhi
 * @create: 2020/04/21 20:53
 */



public class JavaTest2 {

    private static int index = 0;
    private static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
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
            //先序遍历返回数组
            through(node);
            boolean isRight = true;
            List<Integer> temp = new ArrayList<>();
            while (queue.size()>0){
                Integer first = queue.poll();
                Integer second = null;
                if(queue.size()>0){
                     second = queue.peek();
                }else {
                    break;
                }
                if(second!=null && second<=first){
                    isRight = false;
                }
            }
            if(isRight){
                System.out.print("True");
            }else {
                System.out.print("False");
            }
            index = 0;
            queue.clear();
        }
    }

    public static void through(TreeNode node){
        if(node == null) return;
        through(node.left);
        queue.offer(node.val);
        through(node.right);
    }

    public static void buildTree(TreeNode node ,String[] stringArr){
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


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.val = value;
    }
}