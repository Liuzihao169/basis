package alg.tooffer;

import datastructure.tree.Tnode;
import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-11-01-10:41
 * 面试题目27: 二叉树的镜像
 * 输入一颗二叉树，该函数输出它的镜像，
 */
public class Demo27 extends DemoBase {
    @Test
    public void test(){
        Tnode tnode = InitializeTree();
        printInOrder(tnode);
        System.out.print("\n");
        printInOrder(mirrorTree(tnode));
    }



    /**
     * 解题思路:
     * 递归进行交换、返回左右两个节点，然后交换
     * @param tnode
     */
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
     * 递归中序遍历
     * @param tnode
     */
    private void printInOrder(Tnode tnode) {
        if (null != tnode) {
            printInOrder(tnode.lchild);
            System.out.print(tnode.data + "\t");
            printInOrder(tnode.rchild);
        }
    }
}
