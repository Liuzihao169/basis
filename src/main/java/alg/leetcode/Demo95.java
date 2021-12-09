package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzihao
 * @create 2021-11-23-22:05
 */
public class Demo95 {

    public static void main(String[] args) {

    }
}

/**
 * 解题思路:
 * 利用递归的思想：
 * 1-n时
 * 枚举1-n 的第 z个节点
 * 那么可以返回
 * 1-z 左子数集合
 * z-n 右子数集合
 * 两个集合相乘 就是目标集合
 */
class Solution95 {
    public List<TreeNode> generateTrees(int n) {

        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> lists = new ArrayList<>();
        if (start > end){
            lists.add(null);
            return lists;
        }
        for (int i = start; i <= end; i++){
            List<TreeNode> listleft = generateTrees(start,i-1);
            List<TreeNode> listright = generateTrees(i+1,end);
            for (TreeNode left : listleft) {
                for (TreeNode right : listright) {
                    TreeNode currRoot = new TreeNode(i);
                    currRoot.left = left;
                    currRoot.right = right;
                    lists.add(currRoot);
                }
            }
        }
        return lists;

    }
}

