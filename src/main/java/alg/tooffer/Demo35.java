package alg.tooffer;

import diy.ComNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzihao
 * @create 2020-11-20-22:08
 * 复杂链表的复制
 */
public class Demo35 extends DemoBase {
    /**
     *  解题思路：
     *  1、将节点 奇偶 排序复制 如： A-A`-B-B`-C-C`
     *  2、连接扩展节点
     *  3、根据奇偶拆分两个链表
     */
    @Test
    public void test(){

        ComNode<String> node =  initTnode();

        dealCopy(node);

        dealSilbingLink(node);

        Map<String,ComNode > map= dealSplitTnode(node);
        ComNode oldNode = map.get("oldNode");
        ComNode newNode = map.get("newNode");
        printComNode(oldNode);
        printComNode(newNode);
    }

    private void printComNode(ComNode oldNode) {
        ComNode temp = oldNode;
        while (null != temp) {
            System.out.print(temp + "\t");
            System.out.print("sub"+temp.silbing + "\t");
            temp = temp.next;

        }
        System.out.println();
    }

    /**
     * 奇数 偶数节点分离
     * @param node
     * @return
     */
    private Map<String, ComNode> dealSplitTnode(ComNode<String> node) {
        ComNode<String> oldNode = node;
        ComNode<String> newNode = node.next;
        ComNode <String>cur = node;
        int count = 1;
        while (null != cur) {
                ComNode <String> temp =   cur.next;
                cur.next = cur.next.next;
                if (null !=temp.next) {
                    temp.next = temp.next.next;
                }
            count ++;
            cur = cur.next;
        }
        Map<String, ComNode> map = new HashMap<>(2);
        map.put("oldNode", oldNode);
        map.put("newNode", newNode);
        return map;
    }

    /**
     * 复制节点 A-A`-B-B`
     * @param node
     */

    private void dealCopy(ComNode<String> node) {
        if (null == node) {
            throw new RuntimeException("数据不合法");
        }
        ComNode <String>cur = node;
        ComNode <String>temp  = null;
        ComNode<String> nextTemp = null;
        while (cur != null) {
            nextTemp = cur.next;
            if (null != temp) {
                temp.next = cur;
            }
            ComNode<String> newNode = new ComNode<String>(cur.t + "-");
            cur.next = newNode;
            temp = newNode;
            cur = nextTemp;
        }
    }


    /**
     * 处理相临节点
     * @param node
     */
    private void dealSilbingLink(ComNode<String> node) {
        ComNode <String>cur = node;
        int count  = 1;

        while (null != cur) {
            ComNode <String>temp =  cur.next;
            if ((count & 1) != 0 && null !=cur.silbing) {
                temp.silbing = cur.silbing.next;
            }
            cur = cur.next;
            count++;
        }
    }

    private ComNode<String> initTnode() {
        ComNode<String> comNodeA = new ComNode("A");
        ComNode<String> comNodeB = new ComNode("B");
        ComNode<String> comNodeC = new ComNode("C");
        ComNode<String> comNodeD = new ComNode("D");
        ComNode<String> comNodeE = new ComNode("E");
        comNodeA.next = comNodeB;
        comNodeB.next = comNodeC;
        comNodeC.next = comNodeD;
        comNodeD.next = comNodeE;
        comNodeA.silbing = comNodeC;
        comNodeB.silbing = comNodeE;
        comNodeD.silbing = comNodeB;
        return comNodeA;
    }
}
