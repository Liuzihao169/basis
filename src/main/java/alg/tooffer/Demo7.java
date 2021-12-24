package alg.tooffer;

import datastructure.tree.TestSortTree;
import datastructure.tree.Tnode;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzihao
 * @create 2020-09-12-09:17
 * 题目：重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}则重建二叉树并返回。
 *
 */
public class Demo7 {

    /**
     * 解题思路:
     * 前序遍历能够找到根节点 ：1
     * 根据1 可以根据中序 区分左子树后右子树，
     * 左子树中序遍历：4 7 2
     * 左子树前序遍历：2 4 7
     * 问题回到知道 中序 和 前序 后重建二叉树
     * 递归问题:
     * Tnode
     * leftNodes: 左边剩余的节点
     * rightNodes: 右边剩余的节点
     */
    @Test
    public void test(){
    int [] preOrder = {1,2,4,7,3,5,6,8};
    int [] inOrder = {4,7,2,1,5,3,8,6};

        Map<Integer,Integer> map = new HashMap<>();
    // 建立位置关系map
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i],i);
        }
        Tnode tnode = buildTree(preOrder,0,preOrder.length - 1, 0,inOrder.length - 1,map);
        TestSortTree testSortTree = new TestSortTree();
        testSortTree.InOrder(tnode);
    }

    public Tnode buildTree(int[] preorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        Tnode root = new Tnode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            // 从开始位置往右推leftNodes     //从结束位置往左推
            int leftNodes = rootIndex - inorderStart,rightNodes = inorderEnd - rootIndex;
            Tnode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorderStart, rootIndex - 1, indexMap);
            Tnode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd,  rootIndex + 1, inorderEnd, indexMap);
            root.lchild = leftSubtree;
            root.rchild = rightSubtree;
            return root;
        }
    }

    

}
