package leetcode;

import org.junit.Test;

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
        int abb = lengthOfLongestSubstring("add");
        System.out.println(abb);
    }

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
}
