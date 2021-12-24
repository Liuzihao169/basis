package alg.leetcode;

import java.util.Arrays;

/**
 * @author liuzihao
 * @create 2021-12-20-08:29
 */
public class Demo461 {
    public static void main(String[] args) {
        Solution461 solution461 = new Solution461();
        System.out.println(solution461.hammingDistance(4, 1));
        TreeNode treeNode = solution461.sortedArrayToBST(new int[]{ -10,-3,0,5,9});
        System.out.println(treeNode);
    }
}
class Solution461 {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        while(result >0) {
            if((result&1) == 1)count++;
            result = result >>1;
        }
        return count;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return doSortedArrayToBST(nums, 0 ,nums.length - 1);
    }

    public TreeNode doSortedArrayToBST(int [] nums, int start, int end) {
        if(end < start ||start <0 || end>= nums.length){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int midIndex = (start + end)/2;


        TreeNode root = new TreeNode(nums[midIndex]);
        TreeNode left = null;
        TreeNode right = null;
        if(start != midIndex) {
            left = doSortedArrayToBST(nums,start,midIndex - 1);
        }
        right = doSortedArrayToBST(nums, midIndex + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
