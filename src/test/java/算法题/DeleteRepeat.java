package 算法题;

import java.util.ArrayList;

/**
 * @program springbootcachedemo
 * @description: 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author: xielinzhi
 * @create: 2019/05/09 11:09
 */
class Kv{
    public int val;
    public int times;

    public Kv(int val, int times) {
        this.val = val;
        this.times = times;
    }
}
public class DeleteRepeat {

    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return pHead;
        ArrayList<Kv> list = new ArrayList<>();
        ArrayList<Integer> numlist = new ArrayList<>();
        ListNode temp = pHead;
        while(temp != null){
            if(numlist.contains(temp.val)){
                int index = numlist.indexOf(temp.val);
                Kv kv = list.get(index);
                kv.times+=1;
                list.set(index,kv);
            }else {
                numlist.add(temp.val);
                Kv kv = new Kv(temp.val,0);
                list.add(kv);
            }
            temp = temp.next;
        }

        int size = list.size();
        boolean isFirst = true;
        ListNode head = null;
        ListNode last = null;
        for (int i = 0; i < size ; i++) {
            Kv kv = list.get(i);
            if(kv.times == 0){
                if(!isFirst){
                    temp = new ListNode(kv.val);
                    last.next = temp;
                    last = last.next;
                }else {
                    head = new ListNode(kv.val);
                    last = head;
                    isFirst = false;
                }
            }
        }
        return head;
    }
}
