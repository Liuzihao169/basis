package alg.tooffer;

import datastructure.tree.Tnode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-11-18-21:13
 * 二叉树中和为某一值的路径
 *   例如：
 *     10
 *     /｜
 *    5  12
 *   /\
 *  4 7
 *   输入22
 *   输出路径：
 *   10、12
 *   10、5、7
 */
public class Demo34 extends DemoBase{
    /**
     * 解题思路，每次访问的时候存储 访问路径 利用 根左右、先序列遍历的方式
     *
     * 1、递归先序遍历，
     * 2、加入路径队列后，每次判断是否等于目标值 如果等于需要进行打印
     * 3、访问后需要移除路径
     */
    @Test
    public void test(){
        int target = 8;
        Tnode tnode = InitializeTree();
        List<Tnode> list = new ArrayList<>();
        prinRemote(tnode, list, target);
    }

    @Test
    public void test1(){
        String a ="2020-10-10 23:59:59";
        String substring = a.substring(0, 10);
        System.out.println(substring);

    }
    private void prinRemote(Tnode tnode, List<Tnode> list, int target) {
        if (null != tnode) {
            list.add(tnode);
            if (tryPrint(list, target)) {
                prinRemote(tnode.lchild, list, target);
                removeTnode(tnode.lchild, list);
                prinRemote(tnode.rchild, list, target);
                removeTnode(tnode.rchild, list);
            }
        }
    }

    private void removeTnode(Tnode lchild, List<Tnode> list) {
        list.removeIf(a->a.equals(lchild));
    }

    private boolean tryPrint(List<Tnode> list, int target) {
        int totalCount = getTotalCount(list);
        if (totalCount == target) {
            list.forEach(a-> System.out.print(a.data + "\t"));
            System.out.println("");
        }
        return totalCount < target;
    }

    /**
     * 获得总合
     * @param list
     * @return
     */
    private int getTotalCount(List<Tnode> list) {
        int count = 0;
        for (Tnode tnode : list) {
            count += tnode.data;
        }
        return count;
    }
}
