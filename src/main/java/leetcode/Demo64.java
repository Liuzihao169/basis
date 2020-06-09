package leetcode;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2019/12/25-20:02
 * 最小路径之和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class Demo64 {
    //解题思路 利用动态规划：
    //定义状态：DP[i][j] 表示当节点到终点的最短距离
    //动态转移方程:DP[i][j] = min{DP[i+1][j],DP[i][j+1]}
    @Test
    public void test(){
     int [][]  grid = {
             {9,9,0,8,9,0,5,7,2,2,7,0,8,0,2,4,8},
             {4,4,2,7,6,0,9,7,3,2,5,4,6,5,4,8,7},
             {4,9,7,0,7,9,2,4,0,2,4,4,6,2,8,0,7},
             {7,7,9,6,6,4,8,4,8,7,9,4,7,6,9,6,5},
             {1,3,7,5,7,9,7,3,3,3,8,3,6,5,0,3,6},
             {7,1,0,7,5,0,6,6,5,3,2,6,0,0,9,5,7},
             {6,5,6,3,8,1,8,6,4,4,3,4,9,9,3,3,1},
             {1,0,2,9,7,9,3,1,7,5,1,8,2,8,4,7,6},
             {9,6,7,7,4,1,4,0,6,5,1,9,0,3,2,1,7},
             {2,0,8,7,1,7,4,3,5,6,1,9,4,0,0,2,7},
             {9,8,1,3,8,7,1,2,8,3,7,3,4,6,7,6,6},
             {4,8,3,8,1,0,4,4,1,0,4,1,4,4,0,3,5},
             {6,3,4,7,5,4,2,2,7,9,8,4,5,6,0,3,9},
             {0,4,9,7,1,0,7,7,3,2,1,4,7,6,0,0,0}};
     int [][] grig = {
             {1,3,4,8},
             {3,2,2,4},
             {5,7,1,9},
             {2,3,2,3}
     };

        System.out.println("最小路径是================>"+minPathSum2(grig));
        System.out.println("最小路径是================>"+minPathSum(grig));
    }

    public int minPathSum(int[][] grid) {
        int [][] dp = new int [grid.length][grid[0].length];
        for (int i = grid.length-1;i>=0;i--){
            for (int j = grid[0].length - 1;j>=0;j--){
                int a =   Math.min(_gendp(dp,i+1,j)==0?Integer.MAX_VALUE:_gendp(dp,i+1,j),_gendp(dp,i,j+1)==0?Integer.MAX_VALUE:_gendp(dp,i,j+1));
               int temp =  a==Integer.MAX_VALUE?0:a;
                dp[i][j] = temp +grid[i][j];
            }
        }

        for (int [] i: dp){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return dp[0][0];
    }

    //获取路径权值
    int _gendp(int [][]grid,int i,int j ){
        if (i<grid.length&&j<grid[0].length){
            return grid[i][j];
        }
        return 0;
    }
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int row = grid.length;
        int col = grid[row - 1].length;

        int dp[][] = new int[row][col];

        dp[0][0] = grid[0][0];

        for (int i = 1;i < row;i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1;i < col;i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1;i < row;i++) {
            for (int j = 1;j < col;j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        for (int [] i: dp){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return dp[row - 1][col - 1];
    }
}
