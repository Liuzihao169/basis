package alg.tooffer;

import datastructure.stack.Node;
import org.junit.Test;
import sun.awt.geom.AreaOp;

/**
 * @author liuzihao
 * @create 2020-10-27-19:51
 * 面试题23: 链表中环第入口节点
 */
public class Demo23 extends DemoBase{

    /**
     * 解题思路：
     * 利用双节点来处理
     *    |---------
     *    v         |
     * 2->3->3->4->5-
     *
     * 定义p1 每次走一步
     * 定义p2 每次走二步
     * 利用速度差，当p2 追上p1 说明链表中存在环
     */
    @Test
    public void test(){
        Node node = new Node(1) ;
        Node node2 = new Node(2) ;
        Node node3 = new Node(3) ;
        node.next =node2;
        node2.next = node3;
        boolean a = hasCyc(node);
        System.out.println(a);
        node3.next = node2;
        boolean b = hasCyc(node);
        System.out.println(b);
    }

    private boolean hasCyc(Node node) {
        if (null == node) {
            throw new RuntimeException("链表为空");
        }
        if (null == node.next) {
            return false;
        }
        Node p1 = node;
        Node p2 = node;
        while (null != p2 && p2.next != null) {
        p1 = p1.next;
        p2 = p2.next.next;
        if (p1 == p2) {
            return true;
        }

        }
        return false;
    }
}
