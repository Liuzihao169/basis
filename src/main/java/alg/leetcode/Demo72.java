package alg.leetcode;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2019/12/23-14:25
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 定义状态DP[i][j] : 表示word1的前i个字符 转变成 word2的前j个字符 所需要的最小步骤数
 * if word1[i] = word2[j] // 结尾两个字符相同
 * DP[i][j] = DP[i-1][j-1]
 * else
 * DP[i][j] = min{DP[i-1][j],DP[i][j-1],DP[i-1][j-1]} + 1
 *                 删除          添加     替换
 */
public class Demo72 {

    @Test
    public void test(){
        String w1 = "horse";
        String w2 = "ros";
        System.out.println(minDistance(w1,w2));
    }


    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][] dp = new int [m+1][n+1];
        //根据动态方程
        for (int i = 1;i<=m;i++){
            dp[i][0] = i; //初始化数据
            for (int j = 1;j<=n;j++){
            dp[0][j] = j;//初始化数据
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] =  dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
