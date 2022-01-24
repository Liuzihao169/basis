package alg.leetcode;

import org.junit.Test;

/**
 * @author liuzihao
 * @create 2022-01-22-11:15
 */
public class Demo162 {
    @Test
    public void test121(){
        SolutionDemo162 solutionDemo162 = new SolutionDemo162();
        solutionDemo162.findPeakElement(new int[]{1,2});
    }
}
class SolutionDemo162 {
    public int findPeakElement(int[] nums) {
        int left = 0 ;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;

            // 开始判断爬坡的方向 i-1,i,i+1
            if(comapre(nums, mid-1 ,mid) <0 && comapre(nums, mid ,mid + 1) >0){
                return mid;
            }

            if(comapre(nums, mid-1 ,mid) <0) {
                left = left + 1;
            }else{
                right = right - 1;
            }
        }
        return 0;
    }

    int comapre(int [] nums, int index1, int index2) {
        Integer num1 = get(nums, index1);
        Integer num2 = get(nums, index2);
        return num1.compareTo(num2);
    }

    int get(int [] nums, int index){
        if(index == -1 || index == nums.length) {
            return Integer.MIN_VALUE;
        }
        return nums[index];
    }
}