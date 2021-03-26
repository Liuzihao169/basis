package alg.tooffer;

import datastructure.stack.Node;
import datastructure.stack.SqStack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author liuzihao
 * @create 2021-02-23-20:42
 * 面试题目 52： 两个链表的第一个公共节点
 * 1-2-3\
 *       6-7
 *   4-5/
 *如图所示 6就是公共节点
 *
 */
public class Demo52 extends  DemoBase{

    /**
     *解题思路：
     * 1、倒序开始最后一个公共节点就是 第一个公共节点
     *  倒序：利用栈实现
     *
     */
    @Test
    public void test(){
        Node<Integer> node1 = initFirstNode(Arrays.asList(1, 2, 3, 6, 7));
        Node<Integer> node2 = initFirstNode(Arrays.asList(4, 5, 6, 7));

        SqStack<Integer> sqStack1 = new SqStack();
        SqStack<Integer> sqStack2 = new SqStack();

        List<Integer> common = new ArrayList<>();
        pushIntoStack(node1, sqStack1);
        pushIntoStack(node2, sqStack2);
    while (!sqStack1.isEmpty() || !sqStack2.isEmpty()) {
        if (!sqStack1.pop().equals(sqStack2.pop())) {
            break;
        }else {
            Integer pop = sqStack1.pop();
            common.add(pop);
            sqStack2.pop();
        }
    }
    if (common.size() >0) {
        System.out.println(common.get(common.size()-1));
    }else {
        System.out.println("无公共节点");
    }
    }

    private void pushIntoStack(Node<Integer> node1, SqStack<Integer> sqStack) {
        Node <Integer>node = node1;
        Node<Integer> next = node.next;
        while (next !=null) {
            sqStack.push(next.data);
            next = next.next;
        }
    }
    @Test
    public void test12(){
        String pattern = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}";
        boolean matches = Pattern.matches(pattern, null);
        System.out.println(matches);
    }
}
