package alg.tooffer;

import datastructure.tree.Tnode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-11-01-11:33
 * 面试题28：对称的二叉树
 * 如果一个二叉树和它镜像一样，那么它就是对称的
 */
public class Demo28 extends DemoBase {

    /**
     * 构造出一颗树 如下：
     * 1
     * / \
     * 2  3
     * /\  /\
     * 4 5 6 7
     * <p>
     * 解题思路：
     * 1、利用镜像的特点
     * 定义 左根右 与右根左 进行比较 判断是否一致
     */
    @Test
    public void test() {
        Tnode tnode = InitializeTree();
        Tnode tnode1 = mirrorTree(tnode);
        Tnode tnode2 = InitializeTree();

        boolean a = compareIsMirrorTree(tnode1, tnode2);
        System.out.println(a);
    }

    /**
     * 判断是否是镜像
     *
     * @param tnode1
     * @param tnode2
     * @return
     */
    private boolean compareIsMirrorTree(Tnode tnode1, Tnode tnode2) {
        List<Integer> nodes1 = getOrdeLeftInRight(tnode1);

        List<Integer> nodes2 = getOrdeRightInLeft(tnode2);
        if (nodes1.size() == 0 || nodes2.size() == 0) {
            return false;
        }
        if (nodes1.size() != nodes2.size()) {
            return false;
        }
        System.out.println(nodes1);
        System.out.println(nodes2);

        return compareList(nodes1, nodes2);
    }

    private boolean compareList(List<Integer> nodes1, List<Integer> nodes2) {

        for (int i = 0; i < nodes1.size(); i++) {
            if (!equare(nodes1.get(i), nodes2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean equare(Integer i1, Integer i2) {
        if (i1 == null && null == i2) {
            return true;
        }
        if (null != i1 && i1.equals(i2)) {
            return true;
        }
        return false;
    }

    private List<Integer> getOrdeRightInLeft(Tnode tnode2) {
        List<Integer> list = new ArrayList<>();
        if (null == tnode2) {
            return list;
        }
        doOrdeRightInLeft(list, tnode2);
        return list;
    }


    private List<Integer> getOrdeLeftInRight(Tnode tnode1) {
        List<Integer> list = new ArrayList<>();
        if (null == tnode1) {
            return list;
        }
        doOrdeLeftInRight(list, tnode1);
        return list;
    }

    /**
     * 左根右
     *
     * @param list
     */
    private void doOrdeLeftInRight(List<Integer> list, Tnode tnode2) {
        if (null == tnode2) {
            list.add(null);
            return;
        }
        doOrdeRightInLeft(list, tnode2.lchild);
        list.add(tnode2.data);
        doOrdeRightInLeft(list, tnode2.rchild);
    }

    /**
     * 右根左
     *
     * @param list
     */
    private void doOrdeRightInLeft(List<Integer> list, Tnode tnode1) {
        if (null == tnode1) {
            list.add(null);
            return;
        }


        doOrdeRightInLeft(list, tnode1.rchild);
        list.add(tnode1.data);
        doOrdeRightInLeft(list, tnode1.lchild);
    }
}
