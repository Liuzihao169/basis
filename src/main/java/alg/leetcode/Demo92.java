package alg.leetcode;


/**
 * @author liuzihao
 * @create 2021-11-17-20:31
 */
public class Demo92 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode1 = new ListNode(1,new ListNode(2));

        Solution92 solution92 = new Solution92();
        ListNode listNode2 = solution92.headResove(listNode);
        System.out.println(listNode2);
    }
}
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int leftTmp = left;
        ListNode first = new ListNode();
        first.next = head;

        // 只有一个节点
        if (head.next == null) {
            return head;
        }

        // 不需要移动
        if (left ==  right){
            return head;
        }
        ListNode pre =null;
        ListNode cur = first;
        ListNode tmp = null;
        ListNode curNextTmp = null;
        ListNode firstRev = null;
        // 找到 left
        while (cur != null) {
            curNextTmp =  cur.next;
            if (pre != null) {
                cur.next =  tmp;
                tmp = cur;
            }
            if (left == 1){
                pre =  cur;
                firstRev = cur.next;
            }
            if (right == 0) {
                if (firstRev != null && curNextTmp !=null){
                    // 反转数据连接
                    firstRev.next = curNextTmp;
                }
                break;
            }
            left--;
            right--;
            cur =curNextTmp;
        }
        // 数据连接
        if (pre !=null){
            pre.next = tmp;
        }
        if (leftTmp == 1){
            return pre.next;
        }
        return head;
    }

    /**
     * 反转链表 (尾插法)
     * @param listNode
     * @return
     */
    public ListNode resove(ListNode listNode){
        ListNode fisrt = new ListNode();
        fisrt.next = listNode;
        ListNode curr = fisrt;
        ListNode currentNextTmp = null;
        ListNode tmp = null;
        while (curr !=null){
            currentNextTmp = curr.next;
            curr.next = tmp;
            tmp =curr;
            curr = currentNextTmp;
        }
        return tmp;
    }

    // todo 头插法 固定pre 于 cur 中间插入即可
    public ListNode headResove(ListNode listNode) {
        ListNode headNull = new ListNode();
        headNull.next = listNode;
        ListNode pre = headNull;
        ListNode next = null;
        ListNode curr = headNull.next;

        ListNode tmp = null;

        while (curr.next != null){

               next = curr.next;

               tmp = pre.next;
               pre.next = curr.next;
               curr.next = next.next;
               next.next = tmp;

        }
        return headNull.next;
    }
}





