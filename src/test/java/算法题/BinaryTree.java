package 算法题;

import org.junit.Test;

/**
 * @program springbootcachedemo
 * @description: 二叉树操作
 * @author: xielinzhi
 * @create: 2019/05/12 20:37
 */

class Btree{

    int val;
    Btree leftTree;
    Btree rightThree;

    Btree(int val){
        this.val = val;
        leftTree = null;
        rightThree = null;
    }
}

public class BinaryTree {

    Btree root = null;

    public void insert(int value){
        Btree newnode = new Btree(value);


        if(root == null){
            root = newnode;
        }else {
            Btree temp = root;
            while (true){
                Btree parent = temp;
                if(temp.val < newnode.val){
                    temp = temp.rightThree;
                    if(temp == null){
                        parent.rightThree = newnode;
                        return;
                    }
                }else {
                    temp = temp.leftTree;
                    if(temp == null){
                        parent.leftTree = newnode;
                        return;
                    }
                }

            }
        }
    }

    public void first(Btree btree){
        if(btree == null) return;

        System.out.print(btree.val+" ");
        first(btree.leftTree);
        first(btree.rightThree);

    }

    public void last(Btree btree){
        if(btree == null) return;

        last(btree.leftTree);
        last(btree.rightThree);
        System.out.print(btree.val+" ");
    }

    public void mid(Btree btree){
        if(btree == null) return;

        mid(btree.leftTree);
        System.out.print(btree.val+" ");
        mid(btree.rightThree);
    }

    @Test
    public void testTree(){
        insert(5);
        insert(3);
        insert(7);
        insert(8);
        insert(1);
        insert(0);
        insert(2);

        first(root);
        System.out.println();
        mid(root);
        System.out.println();
        last(root);
    }
}
