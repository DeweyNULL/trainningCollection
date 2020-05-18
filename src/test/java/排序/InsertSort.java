package 排序;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program springbootcachedemo
 * @description: 插入排序
 * @author: xielinzhi
 * @create: 2019/05/02 20:11
 */

public class InsertSort {

    public void insertSort(int a[]){
        if(null == a || a.length<2) return;

        for(int i = 1 ; i <a.length;i++){
            int j = i - 1;
            int temp = a[i];
            while (j >= 0 && temp < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }

    }


    @Test
    public void example(){
        int a[] = {2,1,3,4,55,7,8,2,1,0};
        insertSort(a);

        for (int temp:a
             ) {
            System.out.print(temp+",");
        }
    }

    @Test
    public void testRemove(){
        Integer i01=59;
        int i02=59;
        Integer i03=Integer.valueOf(59);
        Integer i04=new Integer(59);

        System.out.println(i01 == i02);
    }

    @Test
    public void teststackAndqueue(){
        Stack stack = new Stack();
        stack.push(1);
        stack.push("asd");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

        Queue queue = new LinkedList();
        queue.add(1);
        queue.offer(2);

        System.out.println(queue.poll());

        System.out.println( queue.isEmpty());

    }


    public void insertagain(int num[]){
        int len = num.length;

        if(len<1) return;

        for (int i = 0; i < len ; i++) {
            for(int j = i-1 ; j<len;j++){

            }
        }
    }
}
