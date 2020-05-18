package 算法题;

import java.util.ArrayList;

/**
 * @program springbootcachedemo
 * @description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @author: xielinzhi
 * @create: 2019/05/09 10:32
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ListReserve {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode reserve = find(listNode);
        ArrayList<Integer> list = new ArrayList<>();
        while (reserve.next!=null){
            list.add(reserve.val);
        }
        return list;
    }

    public ListNode find(ListNode listNode){
        if(listNode == null || listNode.next == null) return listNode;
        ListNode newhead = find(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return newhead;

    }
    //遍历方法：
    public ListNode forfind(ListNode listNode){
        if(listNode==null || listNode.next ==null) return listNode;

        ListNode last = listNode;
        ListNode now = listNode.next;
        ListNode temp ;

        while(now.next != null){
            temp = now.next;
            now.next = last;

            last = now;
            now = temp;
        }
        now.next = last;
        listNode.next = null;

        return now;
    }
}
