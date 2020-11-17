package alg.tooffer;

import datastructure.tree.Tnode;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuzihao
 * @create 2020-11-16-22:01
 * 面试题32: 从上到下打印二叉树 层序列遍历
 */
public class Demo32 extends DemoBase {
    /**
     * 解题思路，通过队列来保存数据
     * 出队列时左右孩子进入队列
     */
    @Test
    public void test2() throws Exception{
        Tnode tnode = InitializeTree();
        layerPrint(tnode);
    }


    private void layerPrint(Tnode tnode) throws Exception {
        LinkedBlockingDeque<Tnode> queue = new LinkedBlockingDeque();
        queue.push(tnode);
        while (!queue.isEmpty()) {
            Tnode pop = queue.poll();
            System.out.print(pop.data + "\t");
            if (null != pop.lchild) {
                queue.put(pop.lchild);
            }
            if (null != pop.rchild) {
                queue.put(pop.rchild);
            }
        }

    }
}
