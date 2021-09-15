package alg.tooffer;

import datastructure.tree.Tnode;
import org.junit.Test;

/**
 * @author liuzihao
 * @create 2021-09-03-08:38
 * 二叉树的深度
 * 输入一颗二叉树的根节点，求二叉树的深度
 */
public class Demo55 extends DemoBase{

    /**
     * 解题思路
     * 当前最大深度h = max( h左子树, h右子树) + 1(当前节点)
     * 递归求解答；
     */
    @Test
    public void test(){
        // 初始化一个默认的树
        Tnode root = InitializeTree();
        int a = getDepth(root);
        System.out.println("当前树的深度为："+a);
    }


    private int getDepth(Tnode tnode) {
        // 递归出口
        if ( null == tnode) {
            return 0;
        }
        // max( h左子树, h右子树) + 1(当前节点)
        return getDepth(tnode.lchild)>getDepth(tnode.rchild) ? getDepth(tnode.lchild)+1 : getDepth(tnode.rchild)+1;
    }
}
