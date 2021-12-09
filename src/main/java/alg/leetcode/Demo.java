package alg.leetcode;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2021-10-17-15:06
 */
public class Demo {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.removeElement(new int[]{3,2,2,3},3);
    }
}
class Solution1 {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int startIndex = -1;
        int endIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            // 数字标记
            if(nums[i] == val){
                if(startIndex == -1){
                    startIndex = i;
                    if(startIndex == nums.length -1){
                        return startIndex;
                    }
                    if (nums[i+1] != val){
                        endIndex = i;
                    }
                    continue;
                }
                endIndex = i;
            }
            // 如果末尾都目标值，直接返回起始值
            if(endIndex == nums.length -1) {
                return startIndex;
            }
            // 开始复制
            if(startIndex != -1 && endIndex != -1) {
                nums[i-(endIndex - startIndex) - 1 ] = nums[i];
            }
        }
        return nums.length -(endIndex - startIndex) - 1;
    }
}
