package leetcode;

import org.junit.Test;
import org.junit.experimental.theories.FromDataPoints;

/**
 * @author liuzihao
 * @create 2019/12/24-11:24
 *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 */
public class Demo62 {
    /**
     * 使用动态规划：
     * 首先定义DP[i][j]：为当前位置 可选择的走法的数量
     * 动态转移方程 DP[i][j] = DP[i][j+1] + DP[i+1][j]
     */
    @Test
    public void test(){
        System.out.println(uniquePaths(7, 3));
    }
     //m*n  m列 n行
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[n][m];
        dp[n-1][m-1] = 1;
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j>=0;j--){
                //跳过最终点的数据
                if (i == n-1&&j == m-1){
                    continue;
                }
                   dp[i][j] = _gendp(dp,i,j+1) + _gendp(dp,i+1,j);
            }
        }
        return dp[0][0];
    }
    //当操出边界时  为0
    int _gendp(int [][]dp,int i,int j ){
        if (i<dp.length&&j<dp[0].length){
            return dp[i][j];
        }
        return 0;
    }
}
