package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2019/12/22-21:38
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class Demo322 {
    @Test
    public void test(){
        //得出动态方程定义DP[i]:总金额为amout时的最小coins数量
        //结果集合 其实也就是动态方程中的一个解
        // J: 0-N coins[n]
        // DP[I] = MIN { DP[I -COINS[J]] }从而可以推导出
        int [] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
    // 输入: coins = [1, 2, 5], amount = 11
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        Arrays.fill(dp,1,dp.length,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++){
                if (i-coins[j] >= 0){
                    dp[i] = Math.min(dp[i-coins[j]] + 1 ,dp[i]);
                }
            }
        }
        // 就是没有赋值
        return dp[amount]>amount ? -1:dp[amount];
    }
}
