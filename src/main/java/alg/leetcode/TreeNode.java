package alg.leetcode;

/**
 * @author liuzihao
 * @create 2021-11-23-22:06
 */
public class TreeNode {
        int val;
        alg.leetcode.TreeNode left;
        alg.leetcode.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, alg.leetcode.TreeNode left, alg.leetcode.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

}
