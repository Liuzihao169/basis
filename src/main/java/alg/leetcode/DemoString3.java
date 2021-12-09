package alg.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hao
 * @create 2019-07-20 ${TIM}
 * 力扣3：无重复子串的长度 ‘abbbdc’==>bdc ===>3
 */
public class DemoString3 {
    @Test
    public void test1(){
        int abb = lengthOfLongestSubstring("abeeeefgacd");
        System.out.println(abb);
    }

    /**
     * 利用滑动窗口 startIndex、endIndex
     * endIndex向前移动，未重复的数据存储在set当中
     * 当  char[start] 在set中已存在，那么 end  移动到 start的位置，窗口开始重新生成...
     * 直到end\start 到尾部
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start  = 0;
        int end = 0;
        int maxlength = 0;
        while (end<s.length()&&start<s.length()){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end++));
                maxlength = Math.max( maxlength , end -start);
            }else {
                set.remove(s.charAt(start++));
            }
        }
        return maxlength;

    }
    class Solution {
        public int minMoves(int[] nums) {
            if(nums.length == 1){
                return 0;
            }
            int count = 0;
            while(true){
                Arrays.sort(nums);
                if(nums[0] == nums[nums.length -1]){
                    return count;
                }
                for(int i = 0; i < nums.length -1; i++){
                    nums[i] = nums[i] + 1;
                }
                count++;
            }
        }
    }

}
