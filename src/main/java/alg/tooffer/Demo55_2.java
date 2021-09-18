package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2021-09-17-08:43
 * 面试题：55-2
 * 判断一棵树是否时 二叉平衡数
 * 条件：任意左右子数的高度差不超过1
 *
 */
public class Demo55_2 extends DemoBase {

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
    public void test(){

    }

}
