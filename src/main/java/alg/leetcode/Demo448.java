package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2021-12-09-08:34
 */
public class Demo448 {

    public static void main(String[] args) {
        Solution448 solution448 = new Solution448();
        solution448.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toString(1111,2));

    }


}

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = (nums[i] - 1) % nums.length;
            nums[index] = nums[index] + nums.length;

        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i]-1 < nums.length){
                list.add(i+1);
            }
        }
        return list;
    }
}