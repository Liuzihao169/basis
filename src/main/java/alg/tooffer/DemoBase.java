package alg.tooffer;

import datastructure.stack.Node;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;


/**
 * @author liuzihao
 * @create 2020-10-15-23:41
 */
public class DemoBase {
    /**
     * 初始化连表
     * @param
     * @return
     */
    protected <T> Node initFirstNode(List<T> list) {

        Node first = new Node();
        Node pre = first;
        for (T o : list) {
            Node node = new Node(o);
            pre.next = node;
            pre = node;
        }
        return first;
    }
    /**
     * 打印
     * @param first
     */
    protected void printNode(Node first) {
        while (null != first) {
            System.out.print(first.data + "\t");
            first = first.next;
        }
        System.out.println();
    }

    protected void printArr(int [] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
