package alg.tooffer;

import datastructure.stack.Node;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzihao
 * @create 2020-10-15-23:24
 * 面试题目19：删除链表中的重复节点
 * 1->2->4->4->5
 * 1->2->5
 */
public class Demo18 extends DemoBase{
    /**
     * 解题思路：
     * 用hashset存值
     *
     */

    @Test
    public void test(){

        Node <Integer> first = initFirstNode(Arrays.asList(1, 2, 4, 4, 5));
        printNode(first);

        duplicateRemoval(first);

        printNode(first);
 //       System.out.println(first);
    }

    /**
     *
     * @param first
     */
    private void duplicateRemoval(Node<Integer> first) {
        Set<Integer> set = new HashSet<>();
        Node pre = null;
        while (null != first) {
            if (exits(set, first)) {
                delete(pre,first);
            }
            pre = first;
            first = first.next;
        }
    }


    /**
     * 是否存在
     * @param set
     * @param first 当前节点
     */
    private boolean exits(Set<Integer> set, Node<Integer> first) {
        if (first == null) {
            return false;
        }
        return ! set.add(first.data);
    }

    /**
     *
     * @param cur 当前节点
     * @param pre 前一个节点
     */
    private void delete( Node pre, Node cur) {

        // 最后一个节点
        if (null == cur.next) {
            pre.next = null;
            return;
        }
        pre.next = pre.next.next;
        // 释放空间
        cur.next = null;
    }

}
