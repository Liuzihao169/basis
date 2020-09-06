package alg.leetcode;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2019/12/12-15:44
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class Demo53 {
    // 定义DP[i]以 i节点为序列的最大值
    //DP[i] = max(arr[i],DP[i-1]+arr[i])
    //结果为 MAX(DP(i),DP(i-1),DP(i-2),DP(i-3)......DP(0))
    @Test
    public void test01(){
        int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int max = Integer.MIN_VALUE;
        int cur_max = 0;
        for (int i = 0; i < arr.length; i++) {
            cur_max = Math.max(cur_max+arr[i],arr[i]);
            max = Math.max(cur_max,max);
        }

        System.out.println(max);
    }
}
