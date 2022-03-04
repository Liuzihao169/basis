package alg.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzihao
 * @create 2022-02-13-22:01
 */
public class Demo3 {

    @Test
    public void test(){
        Solution3 solution3 = new Solution3();
        List<List<Integer>> lists = solution3.threeSum(new int[]{-2,0,1,1,2});
        System.out.println(lists);
    }
}


/**
 * 解题思路：
 *  排序，双指针处理
 * */
class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> targets = new ArrayList<>();
        if(nums.length < 3) return targets;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            if(i>=1&&nums[i] == nums[i-1]){
                continue;
            }
            int L = i+1;
            int R = nums.length -1;
            while(R > L){
                if(-a == nums[R] + nums[L]){
                    targets.add(Arrays.asList(nums[i],nums[L],nums[R]));


                    L++;
                    int curL = L;
                    int next = L+1;
                    while(L<R && nums[curL] == nums[next]){
                        L++;
                    }


                    // 移动R
                    R--;
                    int cur = R;
                    int pre = R-1;
                    while(L<R && nums[cur] == nums[pre]){
                        R--;
                    }

                }else if(nums[R] + nums[L] + a < 0){
                    L++;

                }else if(nums[R] + nums[L] + a > 0){
                    R--;
                }
            }
        }
        return targets;
    }
}