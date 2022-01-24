package alg.leetcode;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2022-01-18-21:56
 */
public class Demo148 {


    @Test
    public void test(){
        ListNode head = new ListNode(3,new ListNode(1,new ListNode(2)));
        ListNode listNode = this.sortList(head);
        System.out.println(listNode);
    }

    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {

        if(head == null){
            return head;
        }
        // 未算尾节点
        if(head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        // 未到达末节点
        while(fast.next !=tail){
            fast =  fast.next;
            slow = slow.next;
            if(fast.next != tail){
                fast = fast.next;
            }
        }

        // slow 为中间节点
        ListNode mid = slow;
        ListNode left =  sortList(head, mid);
        ListNode right = sortList(mid, tail);
        return mergeList(left,right);
    }

    /**
     * 合并两个有序序列
     */
    public ListNode mergeList(ListNode left, ListNode right){
        ListNode empty = new ListNode(0);
        ListNode cur = empty;
        while(left!=null && right !=null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right. next;
            }
            cur = cur.next;
        }
        if(right == null){
            cur.next = left;
        }
        if(left == null){
            cur.next = right;
        }
        return empty.next;
    }
}
