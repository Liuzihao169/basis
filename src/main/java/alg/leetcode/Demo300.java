package alg.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2019/12/16-18:35
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Demo300 {

    //最大连续上升子序列
    @Test
    public void test01(){
        int [] arr = {10,9,2,5,3,7,101,18};
        //解题思路 使用 start 与 end 两个标签来记录每次的 上升起点与终点
        int  start = 1;
        int end = 1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1;i<arr.length-1;i++){
            // 说明开始序列下降 需要处理两件事：
            //1.取出当前序列start与end的差 值 存储 maxValue当中
            //2.start end向前移动
            if (arr[i+1]<arr[i]){
                maxValue = Math.max(end-start+1,maxValue);
                start = i+1;
                end = i+1;
            }else {
                // 结束角标 end向前移动
                end++;
            }
        }
        System.out.println(maxValue);
    }

    //最大上升子序列(可以不连续) 使用递归的方式
    @Test
    public void test02(){
        int [] arr =  {1,3,6,7,9,4,10,5,6};
        List<Integer> max = new ArrayList<>(1);
        max.add(0);
        recursive(arr,0,max,0,Integer.MIN_VALUE);
        System.out.println(max.get(0));
    }

    /**
     * @param arr 目标数组
     * @param start 递归起始点
     * @param max 最大值
     * @param count 递增子序列值
     * @param target 目标比价
     */
     public void recursive(int [] arr ,int start, List<Integer> max , int count,int target){
         //出口
         if (start > arr.length- 1){
             max.add(0,Math.max(max.get(0),count));
         }
         //进行递归
         for (int i = start;i<arr.length;i++){
             //剪枝 1.当前值比目标值大  2.剩余的序列数量大于当前的最大值
             if (arr[i]>target&&(arr.length-start+count>max.get(0))){
                 System.out.println(count);
                 recursive(arr,i,max,count+1,arr[i]);
                 recursive(arr,i+1,max,count,target);
             }
         }
     }

    /**
     * 使用动态规划[10,9,2,5,3,7,101,18]
     * 定义DP[i]:表示到当前第i个元素时的 最大子序列 包括i这个元素
     * 最后的结果是 MAX(DP[0],DP[1],DP[2].....DP[n-1])
     * DP[i] = max(DP[0]--->DP[i-1])+1
     * 并且DP[i]>DP[i-1]
     */
    @Test
    public void test03(){
        int [] arr = {1,2};
        int maxOut = 0;
        int [] dp = new int [8];
        // 初始化第一个DP
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int maxInt = Integer.MIN_VALUE;
            for (int j = 0;j<=i-1;j++){
                if (arr[i]>arr[j]){
                    maxInt = Math.max(dp[j],maxInt);
                }
            }
            dp[i] = maxInt+1;
            maxOut = Math.max(dp[i],maxOut);
        }
        System.out.println(maxOut);
    }
}
