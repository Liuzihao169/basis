package alg.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liuzihao
 * @create 2021-11-15-21:55
 */
public class Demo71 {
    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
      //  solution71.simplifyPath("/...");
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(String.join("/", stack));
    }
}
class Solution71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] items = path.split("/");
        for (String item : items) {
            if (item.isEmpty() || item.equals(".")) continue;
            if (item.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else {
                stack.push(item);
            }
        }
        return "/" + String.join("/", stack);
    }
}
