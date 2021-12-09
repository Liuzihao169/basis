package alg.leetcode;


/**
 * @author liuzihao
 * @create 2021-11-26-21:29
 */
public class Demo86 {
    public static void main(String[] args) {
        Solution86 solution86 = new Solution86();
       ListNode partition = solution86.partition(new ListNode(1,new ListNode(1)), 2);
        System.out.println(partition);
       // System.out.println(solution86.partition(new ListNode(2,new ListNode(1)), 2));

    }
}

class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }
        if (head.next == null ){
            return head;
        }
        ListNode nullHead = new ListNode(99);
        nullHead.next =  head;
        ListNode p1 = nullHead;
        ListNode p2 = nullHead;

        ListNode pre1 = nullHead;
        ListNode pre2 = nullHead;

        // 找到第一个p1
        while(p1 !=null) {
            if(p1.val !=99 &&p1.val > x) {
                break;
            }
            pre1 =p1;
            p1 = p1.next;
        }
        if (p1 == null&&pre1.val >=x){
            return nullHead.next;
        }
        if (p1 == null){
            pre1 =nullHead;
            p1= nullHead;
        }
        p2= p1;
        pre2 = p1;

        while(p2 != null){


            // 找到第二个p1
            if( p2.val < x){
                ListNode tmp = pre1.next;
                pre1.next = pre2.next;
                pre2.next = pre2.next.next;
                pre1.next.next = tmp;
                pre1 = pre1.next;

                p2 = pre2.next;

            }else {
                pre2 = p2;
                p2 =p2.next;
            }



        }
        return nullHead.next;
    }
}
