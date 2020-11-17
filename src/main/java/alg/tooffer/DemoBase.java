package alg.tooffer;

import datastructure.stack.Node;
import datastructure.tree.Tnode;

import java.util.Arrays;
import java.util.List;


/**
 * @author liuzihao
 * @create 2020-10-15-23:41
 */
public class DemoBase {
    public Tnode mirrorTree(Tnode tnode) {
        Tnode node =  doMirrorTree(tnode);
        return node;
    }

    /**
     * 交换
     * @param tnode
     * @return
     */
    public Tnode doMirrorTree(Tnode tnode) {
        if (null == tnode) {
            return null;
        }
        Tnode left = doMirrorTree(tnode.lchild);
        Tnode right = doMirrorTree(tnode.rchild);

        // 交换
        tnode.rchild = left;
        tnode.lchild = right;
        return tnode;
    }
    /**
     * 构造出一颗树 如下：
     * 1
     * / \
     * 2  3
     * /\  /\
     * 4 5 6 7
     */
    public Tnode InitializeTree() {
        Tnode root = new Tnode(1);

        Tnode tnode2 = new Tnode(2);
        Tnode tnode3 = new Tnode(3);
        Tnode tnode4 = new Tnode(4);
        Tnode tnode5 = new Tnode(5);
        Tnode tnode6 = new Tnode(6);
        Tnode tnode7 = new Tnode(7);

        tnode2.lchild = tnode4;
        tnode2.rchild = tnode5;

        tnode3.lchild = tnode6;
        tnode3.rchild = tnode7;

        root.lchild = tnode2;
        root.rchild = tnode3;

        return root;
    }
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
