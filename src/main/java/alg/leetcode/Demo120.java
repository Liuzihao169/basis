package alg.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author liuzihao
 * @create 2019/12/9-20:02
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 */
public class Demo120 {
    //解法一：尝试使用递归的 方法
    //求出中的路径和使用数组存储 然后sort获取到最小值
    @Test
    public void test01() {
        int[][] arr = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3},
        };
        List<Integer> target = new ArrayList<>();
        genTr(target, 0, 0, arr, 0);
        target.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(target);//取出list[0] 就是最小的一个。递归无法解决 超时
    }

    //获得路径之和 使用递归的方法
    void genTr(List<Integer> target, int i, int j, int[][] arr, int pathAndCur) {
        if (i >= arr.length || j >= arr[j].length) {
            return;
        }
        //到达最后一层 就可以把数据存储起来
        if (i == arr.length - 1) {
            target.add(arr[i][j] + pathAndCur);
            return;
        }
        //进行递归
        genTr(target, i + 1, j, arr, pathAndCur + arr[i][j]);
        genTr(target, i + 1, j + 1, arr, pathAndCur + arr[i][j]);
    }

    /**
     * 使用动态规划dp
     * 找出动态转移方程：
     * dp[i,j] = min(dp(i+1,j),dp(i+1,j+1))+arr[i,j] //表示下层到该节点的最小值
     */
    @Test
    public void test02() {
        int[][] arr = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3},
        };

        System.out.println(dp(arr, 0, 0));
    }

    int dp(int[][] arr, int i, int j) {
        if (i >= arr.length || j >= arr[j].length) {
            return 0;
        }
        int left = dp(arr, i + 1, j);
        int right = dp(arr, i + 1, j + 1);
        return left + arr[i][j] < right + arr[i][j] ? left + arr[i][j] : right + arr[i][j];
    }

    //超出时间限制
    @Test
    public void test03() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(dp4list(list, 0, 0));

    }

    int dp4list(List<List<Integer>> list, int i, int j) {
        if (i >= list.size() || j >= list.get(i).size()) {
            return 0;
        }
        int left = dp4list(list, i + 1, j);
        int right = dp4list(list, i + 1, j + 1);
        // 根据公式dp[i,j] = min(dp(i+1,j),dp(i+1,j+1))+arr[i,j] //表示下层到该节点的最小值
        return left + list.get(i).get(j) < right + list.get(i).get(j) ? left + list.get(i).get(j) : right + list.get(i).get(j);
    }

    //使用自底向上的方法dp[i,j] = min(dp(i+1,j),dp(i+1,j+1))+arr[i,j] 求解
    @Test
    public void test04() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        //从倒数第二行开始 因为第一行的值已经确定了
        int[] dp = new int[ list.get(list.size()-1).size()+1];
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < list.get(i).size(); j++) {
                dp[j] = list.get(i).get(j)+dp[j]<list.get(i).get(j)+dp[j+1]?list.get(i).get(j)+dp[j]:list.get(i).get(j)+dp[j+1];
            }
        }
        System.out.println(dp[0]);
    }
}
