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

    private boolean isBalance = true;

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


    /**
     * 解题思路：
     * 1、遍历左右子树，左右子树的深度不超过1 ,
     * 如果从根节点开始遍历，会有很多节点会被重复计算
     *    5
     *   /\
     *  1 3
     * /\ /\
     *1 2 5 6
     *
     * 从底部叶子节点开始计算；
     * 后序遍历进行校验
     */
    @Test
    public void test_2(){
        Tnode root = InitializeTree();

        // 后序遍历校验
        afterOrderCheck(root);
        System.out.println(isBalance);
    }


    /**
     * 后续遍历
     * @param root
     * @return
     */
    private void afterOrderCheck(Tnode root) {
        if (null == root) {
            return;
        }

        afterOrderCheck(root.lchild);
        afterOrderCheck(root.rchild);

        int depthLeft = getDepth(root.lchild);
        int depthRight = getDepth(root.rchild);



       if (Math.abs(depthLeft - depthRight) >= 1){
           System.out.println("当前节点"+root.data+ "左子树深度"+depthLeft + "右子树深度"+depthRight);
           isBalance = false;
       }

    }
}
