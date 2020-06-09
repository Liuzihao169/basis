package Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuzihao
 * @create 2019/11/24-20:10
 */
public class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x;}

     @Test
     public void test(){
         Solution solution = new Solution();
         TreeNode t1 = new TreeNode(1);
         TreeNode t2 = new TreeNode(2);
         TreeNode t3 = new TreeNode(3);
         t2.left = t1;
         t2.right = t3;
         boolean validBST = solution.isValidBST(t2);
         System.out.println(validBST);

     }

    class Solution {
        Stack<Integer> stack = new Stack<Integer>();

        public boolean isValidBST(TreeNode root) {
            List flag = new ArrayList(1);
            ValidBst( root, flag);
            return  flag.size()==0;
        }

        void ValidBst(TreeNode root,List flag){
            if(root != null){
                ValidBst(root.left,flag);
                if(!stack.empty()&&(stack.peek()<root.val||stack.peek()==root.val)){
                    stack.push(root.val);
                }else{
                    flag.add(1);
                }
                ValidBst(root.right,flag);
            }
        }
    }
}
