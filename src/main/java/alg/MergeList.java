package alg;

/**
 * @author liuzihao
 * @create 2021-10-16-19:40
 */
public class MergeList {

  public class ListNode {
    int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 ==null){
                return l2;
            }
            if(null == l2) {
                return l1;
            }
            // 一个链表的每个数据都大于等 另外一个链表
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode empty = new ListNode(0);
            ListNode tmp = null;
            ListNode curTarget = empty;


            while(cur1!=null || cur2 !=null){

                if( cur1 == null || cur2 == null){

                    if(cur1==null){
                        tmp = cur2;
                        cur2 = cur2.next;
                    }else{
                        tmp = cur1;
                        cur1 = cur1.next;
                    }

                }else{
                    if( cur1.val <= cur2.val) {
                        tmp = cur1;
                        cur1 = cur1.next;
                    }else{
                        tmp = cur2;
                        cur2 = cur2.next;
                    }
                }


                curTarget.next = tmp;
                curTarget = tmp;
            }
            return empty.next;
        }

    }

}
