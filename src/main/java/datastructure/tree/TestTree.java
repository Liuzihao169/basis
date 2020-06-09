package datastructure.tree;

import datastructure.queue.Qqueue;
import datastructure.queue.SqQueue;
import datastructure.stack.SqStack;
import javafx.scene.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author hao
 * @create 2019-07-29 ${TIM}
 * 二叉树的测试
 * 二叉搜索树的特点 ：左节点比自己小 右 节点比自己大 查找的时间复杂度O(logn)
 */
public class TestTree {
    Tnode root = new Tnode(1);

    /**
     * 构造出一颗树 如下：
     * 1
     * / \
     * 2  3
     * /\  /\
     * 4 5 6 7
     */
    @Before
    public void InitializeTree() {
        Tnode tnode2 = new Tnode(2);
        Tnode tnode3 = new Tnode(3);
        Tnode tnode4 = new Tnode(4);
        Tnode tnode5 = new Tnode(5);
        Tnode tnode6 = new Tnode(6);
        Tnode tnode7 = new Tnode(7);

        tnode2.lchild = tnode4;
        tnode2.rchild = tnode5;

        tnode3.lchild = tnode6;
        tnode3.rchild = tnode7;

        root.lchild = tnode2;
        root.rchild = tnode3;
    }

    @Test
    public void test() {
        System.out.println("=====先序递归遍历=====");
        PreOrder(root);
        System.out.println();
        System.out.println("=====中序递归遍历=====");
        InOrder(root);
        System.out.println();
        System.out.println("=====后续递归遍历=====");
        PostOrder(root);
        System.out.println();
        System.out.println("=====中序非递归遍历=====");
        InOrderTraverse(root);
        System.out.println();
        System.out.println("=====先序非递归遍历=====");
        PostOrderTraverse(root);
        System.out.println();
        System.out.println("=====后非递归遍历=====");
        PreOrderTraverse(root);
        System.out.println();
        System.out.println("=====层序遍历=====");
        LevelOrder(root);
        System.out.println("=====深度遍历=====");

    }

    //递归先序遍历
    public void PreOrder(Tnode root) {
        if (root != null) {//递归出口
            System.out.print(root.data + " ");
            PreOrder(root.lchild);
            PreOrder(root.rchild);
        }
    }

    //递归中序遍历

    public void InOrder(Tnode root) {
        if (root != null) {//递归出口
            InOrder(root.lchild);
            System.out.print(root.data + " ");
            InOrder(root.rchild);
        }
    }

    //递归后续遍历
    public void PostOrder(Tnode root) {
        if (root != null) {//递归出口
            PostOrder(root.lchild);
            PostOrder(root.rchild);
            System.out.print(root.data + " ");
        }
    }

    //中序非递归

    /**
     * 解答题思路：
     * 循环 ：(当前节点不为空 或 栈道已经为空)
     * 1、从跟节点开始 如果节点不为空入栈 并并且把当且节点指向左孩子
     * 2、如果左孩子为空 那么出栈顶元素 把当且节点指向右孩子
     *
     * @param root
     */
    public void InOrderTraverse(Tnode root) {
        SqStack stack = new SqStack();
        Tnode current = root;//保存当前节点
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);//入栈
                current = current.lchild;
            } else {
                Tnode pop = (Tnode) stack.pop();
                System.out.print(pop.data + " ");
                current = pop.rchild;
            }
        }
    }

    //后序非递归遍历

    /**
     * 接替思路：利用栈
     * 循环：当前节点不为空 或 栈道不为空
     * 1、从当前节点开始 入栈如果左孩子不为空 入栈 当前节点指向当前节点的左孩子
     * 2、当前节点为空 去栈顶元素 (此时栈顶并未出栈)  如果当前栈顶元素的右孩子不为空且没有被访问过 则当前节点指向 栈顶元素的右边孩子
     * 否则 出栈顶元素 并且设立标志 记录当前出的栈顶元素
     *
     * @param root
     */
    public void PreOrderTraverse(Tnode root) {
        SqStack stack = new SqStack();
        Tnode p = null;
        Tnode current = root;//保存当前节点
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.lchild;
            } else {

                Tnode top = (Tnode) stack.getTop();
                if (top.rchild != null && top.rchild != p) {
                    current = top.rchild;
                } else {
                    Tnode pop = (Tnode) stack.pop();
                    System.out.print(pop.data + " ");
                    p = pop;
                }
            }
        }
    }

    /**
     * 先列非递归
     * 思路：根节点入栈
     * 判断栈是否为空 不为空 循环
     * 取栈顶元素 判断栈顶元素是否为空
     * 判断右节点是否为空 不为空入栈
     * 判断当前节点的左节点是否为空 不为空入栈
     *
     * @param root
     */
    public void PostOrderTraverse(Tnode root) {
        SqStack stack = new SqStack();
        Tnode current = root;//保存当前节点
        stack.push(current);
        while (!stack.isEmpty()) {
            Tnode top = (Tnode) stack.getTop();
            if (top != null) {
                Tnode pop = (Tnode) stack.pop();
                System.out.print(pop.data + " ");
                if (top.rchild != null) {
                    stack.push(top.rchild);
                }
                if (top.lchild != null) {
                    stack.push(top.lchild);
                }

            }
        }
    }

    //非递归层序列遍历(广度优先搜索)
    public void LevelOrder(Tnode root) {
        Qqueue queue = new Qqueue();
        queue.EnQueue(root);
        while (!queue.isEmpty()) {
            //出队列
            Tnode current = (Tnode) queue.DeQueue();
            System.out.print(current.data + " ");
            //左孩子入队
            if (current.lchild != null) {
                queue.EnQueue(current.lchild);
            }
            //右孩子入队
            if (current.rchild != null) {
                queue.EnQueue(current.rchild);
            }

        }
    }

    //深度优先搜索 dfs 深度遍历其实就是 先序遍历
    void _DFS(Tnode node) {
        Stack<Tnode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Tnode top = stack.pop();
            System.out.print(top.data + "\t");
            if (top.rchild != null) {
                stack.push(top.rchild);
            }
            if (top.lchild != null) {
                stack.push(top.lchild);
            }
        }
    }

    // 深度优先探索
    @Test
    public void testDFs() {
        _DFS(root);
        Math.max(1, 220);

    }

    // 遍历树的长度
    @Test
    public void testQueue() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.addFirst(11);
        System.out.println(queue.peek());// front 队列前   rear队列尾巴
        Queue<Integer> q = new LinkedList<>();
        StringBuilder   a = new StringBuilder("213");
        a.append(1);
        System.out.println(a.length());
        System.out.println(a.append(1).toString());
    }
    
    @Test
    public void testLeetCode102(){
        //使用递归的方式排序4个括号
        List<String> list = new ArrayList<>();
        _gen(list,"",4,4);
        list.forEach(a-> System.out.println(a));
    }

    /**
     *
     * @param list
     * @param result
     * @param left 左括号剩余
     * @param right 右括号剩余
     */
    void _gen(List<String> list,String s  ,int left,int right) {
        if(right == 0&& left ==0){
            list.add(s);
            return;
        }
        if (left>0) {
            _gen(list,s+"(",left - 1,right);
        }
        if (left<right&&right>0) {
            _gen(list,s+")",left,right - 1);
        }
    }


    // leetCode 51 N皇后问题 利用回溯递归解决
    @Test
    public void test51(){
        List<List<String>> list = solveNQueens(4);
        list.forEach(a-> System.out.println(a));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> listAll = new ArrayList<>();
        Set<Integer> col = new HashSet<>();// 存储这一列存在 N
        Set<Integer> right = new HashSet<>();// 存储右路径存在 N
        Set<Integer> left = new HashSet<>();// 存储左路径 N
        _gen(listAll,new ArrayList<String>(),right,left,col,n,0);
        return  listAll;
    }

    // 同一个list 不断的在复用
    void _gen(List<List<String>> listAll,List<String>list, Set<Integer> right,Set<Integer> left,Set<Integer> col,int n,int level) {
        //递归返回的条件 当到达 第n+1层之后 说明已经遍历完成了
        if (n==level) {
            listAll.add(new ArrayList<String>(list));
        }
        //遍历每一层 进行回溯
        for (int i = 0; i < n; i++) {
            // 行 左斜  右斜不包含皇后N
            if (!(col.contains(i)||left.contains(level-i)||right.contains(level+i))){
                //存储当前 的位置信息
                col.add(i);
                right.add(level+i);
                left.add(level-i);
                //存储该行的位置信息
                char [] c = new char[n];
                Arrays.fill(c,'.');
                c[i] = 'Q';
                list.add(new String(c));
                //下一层进行递归
                _gen(listAll,list,right,left,col,n,level+1);
                //清除该层的 皇后位置信息.
                col.remove(i);
                right.remove(level+i);
                left.remove(level-i);
                // 移除存储存储在末尾的 皇后信息
                list.remove(list.size()-1);
            }
        }

    }

    // leetcode 数独问题36
    //
    @Test
    public void test36(){
        char [][] arr = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        _gen(arr);

        for (int i = 0; i < arr.length; i++) { // 行
            for (int j = 0; j < arr[0].length; j++) { // 列
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
    //递归求解数独  回溯方法 基本回溯
    // 每一个未填数字的方格 进行递归循环 填数字。如果 当前方格填写的数字导致，导致之后的方格完全无法填写
    // 那么需要还原设置
    public boolean _gen(char[][] arr) {
        for (int i = 0; i < arr.length; i++) { // 行
            for (int j = 0; j < arr[0].length; j++) { // 列
                if (arr[i][j] == '.') {
                    for (int c = '1'; c <= '9'; c++) {
                        if (checkNum(arr, i, j, (char) c)) {
                            arr[i][j] = (char)c;
                            if (_gen(arr))
                                return true;
                            else
                                //还原
                                arr[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return  true;
    }

    boolean checkNum(char [][] arr,int row,int col ,char c ){
        // 检查row  检查col 检查 单元九宫格
        for (int i = 0; i < 9; i++) {
            if(arr[row][i]==c)return false;
            if (arr[i][col]==c)return false;
            if(arr[(i/3)+(row/3)*3][(i%3)+(col/3)*3]==c)return false;
        }

        return true;
    }

    @Test
    public void testchar(){
        char [] a = new char[2];
        char c = a[0];
        System.out.println(c);

    }
}
