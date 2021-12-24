package alg;

/**
 * @author liuzihao
 * @create 2021-10-24-23:23
 */
public class Demolist {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(1,new ListNode(2, new ListNode(3,new ListNode(3)))));
        SolutionDemolist solutionDemolist = new SolutionDemolist();
        solutionDemolist.deleteDuplicates(listNode);
        System.out.println(listNode);
    }
}

class SolutionDemolist {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head;
        ListNode firstPre = head;
        ListNode pre ;
        while(next != null){
            pre = next;
            if(next.next == null ||  pre.val != next.next.val){
                firstPre.next = next.next;
                firstPre =  firstPre.next;
            }
            next = next.next;
        }
        return head;
    }
}
 class ListNode {


     int val;
     ListNode next;

     ListNode() {
     }

     ListNode(int val) {
         this.val = val;
     }

     ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }

     @Override
     public String toString() {
         return "ListNode{" +
                 "val=" + val +
                 ", next=" + next +
                 '}';
     }
 }