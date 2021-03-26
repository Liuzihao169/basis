package alg.tooffer;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-12-11-22:56
 * 连续子数组的最大和：
 * 输入一个整数树组，树组里有正数也有负数，求所有子数组中的和最大值
 */
public class Demo42 extends DemoBase {

    /**
     * 解题思路：定义dp[i] 表示以 indx = i 结尾的最大数组的值
     *
     *         data[i]            (i = 0 或者 dp[i-1] <=0)
     * dp[i] =>
     *         dp[i-1] + data[i]  (i != 0 )
     *
     * 需要结果 =  max{dp[0],dp[i].....dp[i]}
     */

    @Test
    public void test(){

    int [] data = {1, -2, 3, 10, -4, 7, 2, -5};
    // 定义dp数组
    int [] dp = new int [data.length];
    int target = dp[0];
    dp[0] = data[0];
    for (int i = 1; i<= data.length - 1; i++) {
        if (dp[i - 1 ] <= 0) {
            dp[i] = data[i];
        }else {
            dp[i] = dp[i-1] + data[i];
        }
        target = Math.max(target, dp[i]);
    }
        System.out.println("最大子数组和为：...." + target);
    }
}
