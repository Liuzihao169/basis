package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author liuzihao
 * @create 2019/12/26-10:07
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 解题思路：利用栈存储
 */
public class Demo32 {
    @Test
    public void test(){
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParentheses2(s));
        System.out.println(longestValidParentheses3(s));
    }

    public int longestValidParentheses(String s) {
        int count = 0;
        int max = 0;
        Stack<Character> stack = new Stack<>();
        if (s==null||s.length()==0){
            return 0;
        }
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    count++;
                    max = Math.max(count,max);
                }else {
                    count=0;
                }
            }
        }
        return max<<1;
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        //System.out.println(stack);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }


    @Test
    public void test02(){
    /**使用动态规划
     * 定义当前状态DP[i] 以这个字符结尾的最大有效括号
     *if s[i] ( dp[i] = 0
     *   s[i] )
     *   if s[i-1] (  dp[i] = dp[i-2]+2
     *      s[i-1] ) 并且 s[i - dp[i - 1] - 1] 为）
     *      dp[i] = dp[i-1]+2 +dp[i-dp[i-1]-2]//判断i-1这个结尾的 最长合法字符的前一个 是否跟最后一个字符匹配
     */
    }

    public int longestValidParentheses3(String s) {
        int res = 0;
        int [] dp = new int [s.length()];
        for (int i =1;i<s.length();i++){
            if (s.charAt(i)==')'){
                if (s.charAt(i-1)=='('){
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
                }else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
            }
        return res;
        }



}
