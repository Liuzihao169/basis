package Test;

import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author hao
 * @create 2019-07-24 ${TIM}
 */
public class StringTest {



    @Test
    public void test4(){
        Queue<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        System.out.println(a.poll());
        System.out.println(a.size());
    }
    @Test
    public void test5(){
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        t20.left=t15;
        t20.right =t7;
        t3.left =t9;
        t3.right =t20;
        SolutionaForTree solutionaForTree = new SolutionaForTree();
        solutionaForTree.levelOrder(t3);


    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
        class SolutionaForTree {
            //使用队列的的形式保存儿子节点
            Queue<TreeNode> queue = new LinkedList<>();

            public List<List<Integer>> levelOrder(TreeNode root) {
                List<List<Integer>> listAll = new ArrayList<>();
                queue.add(root);
                while (queue.peek() != null) {
                    List<Integer> list = null;
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        list = new ArrayList<>();
                        TreeNode temp = queue.poll();
                        list.add(temp.val);
                        if (temp.left != null) {
                            queue.add(temp.left);
                        }
                        if (temp.right != null) {
                            queue.add(temp.right);
                        }
                    }
                    listAll.add(list);
                }
                return listAll;

            }

        }

    }
