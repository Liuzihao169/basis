package alg.leetcode;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2019/12/30-11:44
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3
 */
public class Demo96 {
    /**
     * 定义G(i):代表i有多少种
     * G(i) = f(1)+f(2)....f(n)
     * f(i) 代表 以i为根节点所拥有的不同二叉搜索书
     * f(i) = G(i-1)*G(n-i)(表示左右两边所拥有的种类 进行笛卡尔积)
     */
   @Test
    public void test01(){
       System.out.println(numTrees(3));
   }

    public int numTrees(int n) {
        int [] dp = new int [n+1];
        dp[0]=1;
        dp[1] = 1;
        for (int i  = 2;i<=n;i++){
            for (int j = 1; j <=i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

}
