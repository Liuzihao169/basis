package alg.leetcode;

import lombok.Data;
import lombok.ToString;

/**
 * @author liuzihao
 * @create 2021-11-26-21:31
 */
@Data
@ToString
public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
