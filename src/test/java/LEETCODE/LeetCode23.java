package LEETCODE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program testCollections
 * @description: 合并k个链表并排序
 * @author: xielinzhi
 * @create: 2020/04/26 16:55
 */

public class LeetCode23 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null )
            return null;
        if(lists.length == 1)
            return lists[0];

        int len = lists.length;
        Map<Integer,ListNode> mark = new HashMap<>() ;
        for (int i = 0; i < len; i++) {
            mark.put(i,lists[i]);
        }
        ListNode head = null;
        ListNode temp = null;
        while (true){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < len; i++) {
                ListNode tempNode = mark.get(i);
                if(tempNode!=null && min > tempNode.val){
                    min = tempNode.val;
                    index = i;
                }
            }
            if(index == -1){
                break;
            }
            ListNode next = new ListNode(min);
            if(temp == null){
                head = new ListNode(min);
                temp = head;
            }else {
                temp.next = next;
                temp = next;
            }
            mark.put(index,mark.get(index).next);
        }
        return head;
    }



}
