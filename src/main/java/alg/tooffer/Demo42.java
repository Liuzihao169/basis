package alg.tooffer;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] ints = solution.constructRectangle(37);
        System.out.println();
        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }
    @Test
    public void test3(){
        Solution3 solution = new Solution3();

        System.out.println(solution.searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3));
    }
    @Test
    public void test4(){

        Solution115 solution115 = new Solution115();
        solution115.combinationSum(new int[]{10,1,2,7,6,1,5},8);
        System.out.println(solution115.listAll);
    }

}


/**
 * 解题思路：
 * 1、找到小于目标值的 最小平方数 n
 * W = n, L = n
 * L +1 直到相等 如果 W * L > 目标值得，W, L 进行左右移动
 */
class Solution {
    public int[] constructRectangle(int area) {
        int [] target = new int [2];
        if(area == 1) {
            target[0] = 1;
            target[1] = 1;
            return target;
        }
        int n = getMinN(area);
        int W = n;
        int L = n;
        int i = 0;
        while(true) {
            if(W*L == area) {
                target[0] = W;
                target[1] = L;
                return target;
            }
            if( W*L < area){
                L++;
            }else{
                if(i%2 == 0){
                    W--;
                }else{
                    L++;
                }
                i++;
            }
            if(W==0) {
                break;
            }
        }
        return target;
    }

    public int getMinN(int area){
        int  i = 1;
        while(true){
            if(i*i > area) {
                return i - 1;
            }
            i++;
        }
    }
}


class Solution3 {

    public int[] searchRange(int[] nums, int target) {

        int [] arr = new int[]{-1,-1};
        if(nums.length == 0 || nums[0] > target) {
            return arr;
        }
        int index = findTarget(nums,0,nums.length - 1, target);
        if(index == -1 || nums[index] != target) {
            return arr;
        }
        int left = index;
        int right = index;

        // 找右边界
        while(true) {
            if(right< nums.length - 1 && nums[right + 1] == target) {
                right++;
                continue;
            }
            break;
        }
        // 找左边界
        while(true){
            if(left > 0 && nums[left - 1] == target) {
                left--;
                continue;
            }
            break;
        }
        arr[0] = left;
        arr[1] = right;
        return arr;

    }
    // 寻找到目标值
    public int findTarget(int[] nums, int start, int end, int target) {
        if(start == end ){
            return end;
        }

        Character a = 'c';
        if(start < 0 || end >= nums.length) {
            return -1;
        }
        if(nums[(start + end)/2] == target) {
            return (start + end)/2;
        }else if(nums[(start + end)/2] > target){
            return findTarget(nums, start, (start + end)/2 - 1, target);
        }else {
            return findTarget(nums, (start + end)/2 + 1, end, target);
        }
    }
    public String getByCharacter(Character c) {
        if(c == '2') {
            return "abc";
        }else if(c == '3') {
            return "def";
        }else if(c == '4') {
            return "ghi";
        }else if(c == '5') {
            return "jkl";
        }else if(c == '6') {
            return "mno";
        }else if(c == '7') {
            return "pqrs";
        }else if(c == '8') {
            return "tuv";
        }else if(c == '9'){
            return "wxyz";
        }
        return "";
    }
}

class Solution12 {
    /**
     *
     * 解题思路: 模拟二进制相加
     *
     * */
    public String addBinary(String a, String b) {
        String maxStr ="";
        String minStr ="";
        if(a.length() >= b.length()) {
            maxStr = a;
            minStr = b;
        }else{
            maxStr = b;
            minStr = a;
        }
        StringBuilder str = new StringBuilder();
        char nextAdd = '0';
        int j = 0;
        for(int i = maxStr.length() - 1; i>= 0; i--) {
            char a1 = maxStr.charAt(i);
            char b1 = '0';
            if( j < minStr.length()){
                b1 = minStr.charAt(minStr.length() - 1 - j);
            }
            if(a1 + b1 == '1' + '1' ){
                if(nextAdd == '1'){
                    str.append("1");
                }else{
                    str.append("0");
                }
                nextAdd = '1';
            }else if(a1 + b1 == '1' + '0' ){
                if(nextAdd == '1') {
                    str.append("0");
                    nextAdd = '1';
                }else{
                    str.append("1");
                }
            }else {
                if(nextAdd == '1') {
                    str.append("1");
                    nextAdd = '0';
                }else{
                    str.append("0");
                }
            }
            j++;
        }
        if(nextAdd == '1') {
            str.append("1");
        }
        return str.reverse().toString();
    }
}

class Solution115 {
    /**
     * 利用回溯法 枚举所有的解
     * 回溯的思路 就是枚举 + 恢复 如何此解不符题意义
     *
     * */
    List<List<Integer>> listAll = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int target = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        List<List<Integer>> list = new ArrayList<>();
        dfs(candidates,0);
        return listAll;
    }

    private void dfs(int[] candidates,int start){
        if(target < 0) {
            return;
        }
        if(target == 0){
            listAll.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length;i++){
            this.target =  this.target - candidates[i];
            list.add(candidates[i]);
            dfs(candidates,i);
            this.target =  this.target + candidates[i];
            list.remove(list.size() - 1);
            list = new ArrayList<>(list);
        }
    }
}

