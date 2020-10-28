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
public class Demo6 extends DemoBase{
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

    @Test
    public void test2(){
        Node head = bulidListNode();
        Node ne = new Node();
        revHead(head,ne);
        printNode(ne.next);

    }

    /**
     * 反转链表、定义3个变量，
     * pre 新链表的头节点
     * cur 正在处理old链表的当前节点
     * next 下一个节点，用于保存现场
     */
    @Test
    public void test3(){
        Node head = bulidListNode();
        Node firsthead =  rev(head);
        printNode(firsthead);
    }

    private Node rev(Node head) {
        // 初始化成头节点
        Node cur  = head.next;
        Node pre = head;
        // 需要第一步初始化为null
        pre.next = null;
        Node next;
        while (null != cur) {
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private Node revHead(Node head,Node newh) {
        Node cur = null;
        if (head !=null && null !=head.next) {
            cur = revHead(head.next, newh);
        }
        if (head.next == null){
            // 存储尾节点
            newh.next = head;
            return head;
        }else {
            cur.next = head;
            // 解除头部循环
            if (head.data == null) {
                head.next = null;
            }
            return head;
        }

    }

    /**
     * 使用递归 递归是天然的栈
     */
    @Test
    public void test1(){
        Node node = bulidListNode();
        System.out.println("从尾到头打印的队列是:");
        printNode1(node);
    }

    private void printNode1(Node node) {

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
