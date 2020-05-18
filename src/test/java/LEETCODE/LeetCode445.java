package LEETCODE;

import java.util.ArrayList;
import java.util.List;

/**
 * @program testCollections
 * @description:
 * @author: xielinzhi
 * @create: 2020/04/28 16:41
 */

public class LeetCode445 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> l1List = new ArrayList<>();
        List<Integer> l2List = new ArrayList<>();
        while (l1!=null){
            l1List.add(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            l2List.add(l2.val);
            l2 = l2.next;
        }

        int i= l1List.size() - 1;
        int j = l2List.size() - 1;
        ListNode last = null;
        ListNode head = null;
        int lastNum = 0;
        while (i>=0 || j>= 0){
            int num = 0;
            if(i >=0 && j>=0 ){
                num = l1List.get(i--) +l2List.get(j--);
            }else if(i>=0 && j<0){
                num = l1List.get(i--);
            }else if(j>=0 && i<0){
                num = l2List.get(j--);
            }
            if(lastNum>0){
                num+=lastNum;
            }
            if(num>9){
                num-=10;
                lastNum = 1;
            }else {
                lastNum = 0;
            }
            head = new ListNode(num);
            if(last == null){
                last = head;
            }else {
                head.next = last;
                last = head;
            }
        }
        if(lastNum>0){
            head = new ListNode(1);
            head.next = last;
        }
        return head;
    }
}
