package alg.tooffer;

import datastructure.stack.Node;
import org.junit.Test;

import java.util.Stack;

/**
 * @author liuzihao
 * @create 2020-09-09-22:07
 * 剑指offer
 * 题目六：从到尾打印链表
 * head -> 5 ->10 ->11 -> 15
 */
public class Demo6 {
    /**
     * 解题思路使用额外的存储空间 栈
     */
    @Test
    public void test(){
        Stack<Node>stack = new Stack();
        Node head = bulidListNode();
        Node node = head;
        while (node.next !=null){
            node = node.next;
            stack.push(node);
        }
        System.out.println("从尾到头打印的队列是:");
        while (!stack.empty()) {
            System.out.print(stack.pop().data+"\t");
        }
    }

    /**
     * 使用递归 递归是天然的栈
     */
    @Test
    public void test1(){
        Node node = bulidListNode();
        System.out.println("从尾到头打印的队列是:");
        printNode(node);
    }

    private void printNode(Node node) {

        if (node.next != null){
            printNode(node.next);
        }
        if (node.data != null) {
            System.out.print(node.data + "\t");
        }
    }

    public Node bulidListNode() {
        Node head = new Node();
        Node n1 = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(11);
        Node n4 = new Node(15);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return head;

    }
}
