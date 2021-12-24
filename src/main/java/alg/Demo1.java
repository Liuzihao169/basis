package alg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzihao
 * @create 2021-10-18-22:24
 */
public class Demo1 {
    //[4,1,2]
    //[1,2,3,4]
    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        solution123.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2} );
    }
}




/**
 **  解题思路：
 * 1、类似于3数之和，利用 排序+ 枚举 + 双指针
 * 2、3层循环暴力破解
 **
 ** */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 3) {
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                total = total + nums[i];
            }
            return total;
        }
        // 排序
        Arrays.sort(nums);
        int L = 0;
        int R = 0;
        int mineuqal = 10000;
        for (int i = 0; i < nums.length; i++) {
            // 相等的话就跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 转化成 剩余两数之和
            int targetNew = target - nums[i];
            L = i + 1;
            R = nums.length - 1;
            // 另外两数之后尽量等于 targetNew
            while (L < R) {

                if (Math.abs(nums[L] + nums[R] + nums[i] - target) < Math.abs(mineuqal - target)) {
                    mineuqal = nums[L] + nums[R] + nums[i];
                    break;
                }

                if (nums[L] + nums[R] == targetNew) {
                    mineuqal = target;
                } else if (nums[L] + nums[R] > targetNew) {
                    R--;
                } else if (nums[L] + nums[R] < targetNew) {
                    L++;
                }

            }
        }
        return mineuqal;
    }
}

class Solution123 {
    //4,1,2},new int[]{1,2,3,4}  (-1,3,3)
    // 4-0
    // 1-2
    // 2-3
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],i);
        }
        int[] arr = new int[nums1.length];
        for(int i = 0; i < nums2.length; i++) {
            if(!map.containsKey(nums2[i])){
                continue;
            }
            int target = -1;
            for(int j = i + 1; j < nums2.length - 1; j++){
                if(nums2[i] < nums2[j]){
                    target = nums2[j];
                    break;
                }

            }
            arr[map.get(nums2[i])] = target;
        }
        return arr;
    }
}