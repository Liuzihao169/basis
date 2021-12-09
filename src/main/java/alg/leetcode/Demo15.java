package alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzihao
 * @create 2021-10-16-22:14
 *
 * 三数之和：
 * three
 */
public class Demo15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        if(nums.length <3) {
            return list;
        }
        // 排序
        Arrays.sort(nums);
        int LIndex =0;
        int Rindex =0;
        int target = 0;
        for(int i = 0; i < nums.length; i++){
            target = -nums[i];
            if (i>1 && nums[i-1]==nums[i]){
                continue;
            }
            LIndex = i+1;
            Rindex = nums.length -1;
            while (LIndex < Rindex) {
                if (nums[LIndex] + nums[Rindex] == target) {
                    // 找到目标值得
                    list.add(Arrays.asList(nums[i], nums[LIndex], nums[Rindex]));
                }
                // 右指针左移动
                if (nums[LIndex] + nums[Rindex] > target) {
                    Rindex--;
                    while (Rindex >1 && nums[Rindex] == nums[Rindex - 1]){
                        Rindex--;
                    }
                }else {
                    LIndex++;
                    while (LIndex <nums.length -1 && nums[LIndex] == nums[LIndex + 1]) {
                        LIndex++;
                    }
                }
            }
        }
        return list;
    }
}