package alg.leetcode;

/**
 * @author liuzihao
 * @create 2021-11-27-10:15
 */
public class Demo82 {
    public static void main(String[] args) {
        Solution82 solution82 = new Solution82();
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        solution82.deleteDuplicates(listNode);
    }
}
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {



        ListNode nullHead = new ListNode(-1);
        nullHead.next = head;
        ListNode pre = nullHead;
        ListNode cur = nullHead;
        ListNode tmpPre = nullHead;

        int sameValue = -1;
        while(cur != null) {
            while(cur !=null) {
                if(cur.next != null && cur.next.val == cur.val) {
                    sameValue = cur.val;
                    break;
                }
                tmpPre = cur;
                pre = cur;
                cur = cur.next;
            }
            if(cur == null) {
                return nullHead.next;
            }
            ListNode nextTmep = cur.next;
            while(nextTmep != null){
                if(nextTmep.val!= sameValue){
                    break;
                }
                nextTmep = nextTmep.next;
            }
            pre.next = nextTmep;
            cur = nextTmep;
        }
        return nullHead.next;
    }
}