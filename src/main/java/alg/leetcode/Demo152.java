package alg.leetcode;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2019/12/11-10:43
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class Demo152 {
    @Test
    public void test01(){
        int [] nums = new int[] {2,3,-2,4};
        /**
         * 定义动态方程 DP[i] :表示以i结尾区间的最大值
         * DP[i] = DP[i-1] + arr[i]//这种类似于斐波拉契数列的推导式 ；看似正确 但是当arr[i]为负数时，求出的确是最小值
         * 所以就再需要一个空间存储 最小值 。综合起来 状态转移方程如下：
         * DP_MIN[i]:表示负的最大的值
         * DP_MAX[i]:最大值
         *  arr[i]>0 时DP_MIN[i] = min(DP_MIN [i-1]*arr[i],arr[i])
         *             DP_MAX[i] = max(DP_MAX[i-1]*arr[i],arr[i])
         *  arr[i]<0 时DP_MIN[i] = max(DP_MAX[i-1]*arr[i],arr[i])
         *             DP_MAX[i] = min(DP_MIN [i-1]*arr[i],arr[i])
         *  最后取出所有的 DP_MAX[i] 取出最大值即可
         */
        //最后结果为：max(DP_MAX[i],DP_MAX[i-1],DP_MAX[i-2],DP_MAX[i-3],DP_MAX[i-4].....DP_MAX[0])
        //尚上面的DP可以用临时变量来存储 cur_min 与 cur_max
        int max = 0, cur_max = 1, cur_min = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = cur_max;
                cur_max = cur_min;
                cur_min = tmp;
            }
            cur_max = Math.max(cur_max*nums[i], nums[i]);
            cur_min = Math.min(cur_min*nums[i], nums[i]);

            max = Math.max(max, cur_max);
        }

        System.out.println(max);
    }
}
