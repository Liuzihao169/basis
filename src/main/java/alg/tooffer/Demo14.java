package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-10-07-15:38
 * 面试题14：剪绳子
 * 题目：给你一根长度为n的绳子，请把绳子剪成m段，每段绳子段长度记为k[0]、k[1]、k[m]，求
 * k[0]*k[1]*.....*k[m]的最大乘积是多少?
 * m > 1; n > 1
 */
public class Demo14 {
    /**
     * 解题思路：最优解、利用动态规划，解决问题：
     * a.有最优解
     * b.可以分解成子问题
     * c.子问题有重叠的部分
     *
     * dp[n] = max{dp[n-i] * dp[n]} 0< i < n
     * 构建最底层基础数据，然后自底向上解决问题。
     * dp[0] = 0
     * dp[1] = 1
     * dp[2] = 2
     * dp[3] = 3
     * dp[4] = max{dp[1]*dp[3], dp[2]*dp[2]} = 4
     * dp[5] = max{dp[1]*dp[4], dp[2]*dp[3]}
     *
     * 构建dp存储数据 自低像上
     */
    @Test
    public void test(){
        System.out.println("长度为8的时候: \t " + multiplyMax(8));
        System.out.println("长度为2的时候: \t " + multiplyMax(2));

    }

    /**
     * 类积最大值
     * @param lineLong
     * @return
     */
    int multiplyMax(int lineLong){
        if (lineLong <=1) {
            throw new RuntimeException("参数不合法");
        }
        if (lineLong == 2) {
            return 1;
        }
        if (lineLong == 3) {
            return 2;
        }

       int [] dp = new int[lineLong + 1];
       initDP(dp);
       for (int i = 4; i<= lineLong; i++) {
           int dpI = getDPI(i, dp);
           dp[i] = dpI;
       }
        return dp[lineLong];
    }

    /**
     * 获得i时的最大值
     * @param i
     * @param dp
     * @return
     */
    private int getDPI(int i, int[] dp) {
        int max = 0;
        for (int j = 1; j <= i / 2; j++) {
            max = dp[j] * dp[i-j] > max ?dp[j] * dp[i-j]:max;
        }
        return max;
    }

    /**
     * 初始化数组
     * @param dp
     */
    private void initDP(int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
    }
}
