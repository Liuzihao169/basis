package alg.tooffer;

import datastructure.tree.Tnode;
import org.junit.Test;

/**
 * @author liuzihao
 * @create 2021-03-21-21:45
 * 面试题54：二叉搜索树到第K个大节点
 * 题目：给定一个二叉搜索数，请找出其中第K个大大节点
 *     5
 *    /\
 *   3 7
 *  /\ /\
 * 2 4 6 8
 * 二叉搜索数的 中序遍历就是 从小到达的顺序的
 */
public class Demo54 extends DemoBase {

    int i = 0;

    @Test
    public void test(){
        Tnode root = initializeSortFindTree();

        Tnode tnode = findK(root,2);
        if (tnode != null) {
            System.out.println(tnode.data);
        }

    }

    /**
     * 中序遍历找到第K个节点
     * @param root
     * @param k 第K个节点
     * @return
     */
    Tnode target = null;

    private Tnode findK(Tnode root,int k) {

        if (root !=null){
            target = findK(root.lchild, k);
            i++;
            if (i == k){
                target =  root;
            }
            if (target == null) {
                target = findK(root.rchild,k);
            }
        }
        return target;
    }
}
