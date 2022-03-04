package alg.leetcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author liuzihao
 * @create 2022-02-28-20:13
 */
public class Demo143 {

    @Test
    public void test(){
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        Solution143 solution143 = new Solution143();
        solution143.reorderList2(listNode1);
    }
}
class Solution143 {
    public void reorderList(ListNode head) {
        if(head ==null || head.next == null) return ;
        LinkedList<ListNode> list = new LinkedList<>();
        while(head !=null){
            list.offer(head);
            head =head.next;
        }
        ListNode temp = null;
        ListNode cur = null;
        int i = 0;
        while(!list.isEmpty()) {
            if(i%2 == 0){
                temp = list.pollFirst();
            }else{
                temp = list.pollLast();
            }
            temp.next =null;
            if(cur !=null){
                cur.next = temp;
                cur = temp;
            }else {
                cur = temp;
            }
            i++;
        }
    }

    public void reorderList2(ListNode head) {
        if(head ==null || head.next == null) return ;
        // 寻找中点
        ListNode mid = middleNode(head);
        ListNode l2 = mid.next;
        mid.next = null;
        // 反转链表
        ListNode newHead = null;
        while(l2 !=null){
            ListNode tmp = l2.next;
            l2.next = newHead;
            newHead = l2;
            l2 = tmp;
        }

        // 合并head 与 newHead

        merge(head ,newHead);


    }

    void merge(ListNode l1, ListNode l2) {
        ListNode temp1;
        ListNode temp2;

        while (l1!=null && l2!=null) {
            temp1 = l1.next;
            temp2 = l2.next;

            l1.next = l2;
            l1 = temp1;

            l2.next = l1;
            l2 = temp2;

        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
