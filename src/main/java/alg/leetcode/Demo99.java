package alg.leetcode;


/**
 * @author liuzihao
 * @create 2021-11-16-18:59
 */
public class Demo99 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(1,null,null),new TreeNode(4,new TreeNode(2),null));
        Solution99 solution99 = new Solution99();
        solution99.recoverTree(root);
        System.out.println(solution99.f);
        System.out.println(solution99.s);
        System.out.println(solution99.pre);

    }
}



class Solution99 {
    /**
     * 解提思路:
     * 利用二叉搜索树的特性 中序遍历的 为增序排序数据
     * 如果两个值被调换，中序遍历时出现 当前节点的值 小于 前一个节点 时就可以判断改节点有问题
     *
     * a1 a2 a3 a4 a5
     * a2 > a3  a2
     * a4 > a5 a5
     *输入：root = [3,1,4,null,null,2]
     * 输出：[2,1,4,null,null,3]
     */


        TreeNode pre = null;
        TreeNode f = null;
        TreeNode s = null;

        public void recoverTree(TreeNode t) {
            dfs(t);

            // 尝试交换
            if (f != null && s !=null){
                int tmp = f.val;
                f.val = s.val;
                s.val = tmp;
            }


        }

        private void dfs(TreeNode t) {
            if (t != null){
                dfs(t.left);
                // 主逻辑
                    if (pre != null){
                        if (t.val < pre.val) {
                                // 第二个节点赋值
                                s = t;
                            if (f == null){
                                f = pre;
                            }
                        }
                    }
                    pre = t;
                dfs(t.right);
            }
        }
    }
