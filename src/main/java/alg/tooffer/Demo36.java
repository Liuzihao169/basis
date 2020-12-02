package alg.tooffer;

import datastructure.tree.Tnode;
import diy.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-11-24-10:06
 * 面试题36：二叉搜索树与双向列表
 * 输入一个二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 */
public class Demo36 extends DemoBase {
    /**
     *      *   10
     *      *   / \
     *      *  6  14
     *      * /\  /\
     *      *4 8 12 16
     *解题思路：
     * 4-6-10-14-12-16
     * 其实就是 二叉树的 中序遍历
     */
    @Test
    public void test(){
        Tnode tnode = initializeSortFindTree();
        Node node = changeLinkNode(tnode);
        System.out.println(node);
    }


    /**
     * 将二叉树转换成双向链表
     * 中序遍历 + 构造
     * @param tnode
     * @return
     */
    private Node changeLinkNode(Tnode tnode) {
        Node node = null;
        Node last = null;
        Node temp = null;
        List<Tnode> list = changeToList(tnode);
        for (Tnode tnode1 : list) {
            if (null == node) {
                node = new Node(tnode1.data);
                last = node;
            }else {
                temp = last;
                last = new Node(tnode1.data);
                temp.prefix = last;
                last.sufix = temp;
            }
        }
        return node;
    }

    private List<Tnode> changeToList(Tnode tnode) {
        List<Tnode> list = new ArrayList<>();
        prinInList(tnode, list);
        return list;
    }

    private void prinInList(Tnode tnode, List<Tnode> list) {
        if (null != tnode) {
            prinInList(tnode.lchild, list);
            list.add(tnode);
            prinInList(tnode.rchild, list);
        }
    }

}
