package alg.tooffer;

import datastructure.tree.Tnode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-10-29-20:45
 * 面试题目26: 树的子结构
 * 输入两课二叉树A、B 判断B是不是A的子结构
 *
 *      * 构造出一颗树 如下：
 *      * 1
 *      * / \
 *      * 2  3
 *      * /\  /\
 *      * 4 5 6 7
 *
 *     3
 *     /\
 *    6  7
 *
 *
 * */

public class Demo26 extends DemoBase{

    /**
     *解题思路：
     * 先找到与子树相同的根节点，然后递归遍历子树与 主树，然后进行判断.
     * 小结：
     * 可以通过递归子结果，影响递归结果
     */
    @Test
    public void test(){
        Tnode tnode = InitializeTree();
        Tnode tnode1 = new Tnode(3);
        Tnode tnode2 = new Tnode(6);
        Tnode tnode3 = new Tnode(1);
        tnode1.lchild = tnode2;
        tnode1.rchild = tnode3;
        boolean b = findChildTree(tnode, tnode1);
        System.out.println(b);
    }

    /**
     * 判断是否是子树
     * @param tnode
     * @param child
     * @return
     */
    private boolean findChildTree(Tnode tnode, Tnode child) {
        if (null == tnode || null == child) {
            return false;
        }
        List<Tnode> list = findRoot(tnode, child) ;
        if (list.size() == 0) {
            return false;
        }
        for (Tnode node : list) {
            if(comparChild(node, child)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 递归进行比较
     * @param node
     * @param child
     * @return
     */
    private boolean comparChild(Tnode node, Tnode child) {
        boolean a  = true;
        boolean b = true;
        if (null != node || null != child) {
            if (null == node || null  == child || node.data != child.data) {
                return false;
            }
            a = comparChild(node.lchild, child.lchild);
            b = comparChild(node.rchild, child.rchild);

        }
        // 左右子树都没有出现不相同时 返回true
        return a && b;
    }

    /**
     * 在主树上找到 与子树跟节点相同的节点
     * @param tnode
     * @param child
     * @return
     */
    private List<Tnode> findRoot(Tnode tnode, Tnode child) {
        List<Tnode> childTnode = new ArrayList<>();
        dofindRoot(tnode, child, childTnode);
        return childTnode;
    }

    private void dofindRoot(Tnode tnode, Tnode child, List<Tnode> childTnode) {
        if (null != tnode) {
            if (tnode.data == child.data) {
                childTnode.add(tnode);
            }
            dofindRoot(tnode.lchild, child, childTnode);
            dofindRoot(tnode.rchild, child, childTnode);

        }
    }
}
