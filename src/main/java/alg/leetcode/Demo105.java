package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzihao
 * @create 2021-11-21-23:41
 */
public class Demo105 {
    public static void main(String[] args) {

    }
}

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        // 建立 中序 位置关系map 推出左右子树节点的个数
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        TreeNode node = bulidTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
        return node;
    }
    /*
     * 重建二叉数
     */
    private TreeNode bulidTree(int[] preorder , int pStartIdx, int pEndIdx, int iStartIdx, int iEndIdx, Map<Integer,Integer> inOrderIdx){
        if(pStartIdx > pEndIdx){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStartIdx]);
        if(pStartIdx == pEndIdx){
            return root;
        }else{
            // 获得根节点 index
            int rootIndex = inOrderIdx.get(preorder[pStartIdx]);
            // 左子数 节点长度
            // 右子数 节点长度
            int leftSize = iStartIdx - rootIndex;
            int rightSzie = iEndIdx - rootIndex;
            // 左子树
            root.left = bulidTree(preorder, pStartIdx + 1, pStartIdx  + leftSize, iStartIdx, rootIndex -1, inOrderIdx);
            // 右子树
            root.right = bulidTree(preorder, pStartIdx + leftSize + 1, pEndIdx, rootIndex + 1, iEndIdx, inOrderIdx);
            return root;
        }


    }
}