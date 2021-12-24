package alg.tooffer;

import datastructure.stack.Node;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2020-10-27-19:21
 * 面试题22：链表中的倒数第K个节点
 */
public class Demo22 extends DemoBase {
    /**
     * 解题思路：
     * 思路一：遍历两次 第一次拿到链表长度、第二次开始获取倒数K个节点
     * 思路二：利用双节点，p1在表头，p2在 k-1 位置，然后 拍p1与p2同步移动，当p2到达末尾的适合，p1所在的位置就是 倒数K个节点
     */
    @Test
    public void test() {
        // 生成带头节点的链表
        Node head = initFirstNode(Arrays.asList(3, 4, 5, 6, 3, 5, 6));
        System.out.println(getReciprocalKNode(head, 3).data);
    }

    Node getReciprocalKNode(Node head, int k) {
        if (k < 0) {
            throw new RuntimeException("输入第倒数K不合法");
        }
        Node node = head.next;
        if (null == node) {
            throw new RuntimeException("链表不合法");
        }
        Node cur = node;
        // cur移动到 k-1个节点
        while (k - 1 > 0) {

            cur = cur.next;
            k--;
        }


        // cur 与 node 同步移动
        while (null !=cur.next) {
            node =  node.next;
            cur = cur.next;
        }
        return node;
    }
}
