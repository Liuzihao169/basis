package datastructure.tree;

import org.junit.Test;

/**
 * @author hao
 * @create 2019-08-04 ${TIM}
 * 构建查找树 也就是排序二叉树 左孩子比自己小 右孩子大于等于自己
 */
public class TestSortTree {

    @Test
    public void test(){
        //根据数组初始化排序二叉树
        Tnode root = new Tnode();
        int arr [] ={6,3,9,5,1,11};
        Tnode tnode = InitializeTree(arr);
        InOrder(tnode);
    }

    @Test
    public void test3(){
        int arr [] ={6,3,9,5,1,11};
        Tnode root = new Tnode();
        InitializeTree2(arr,root);
        InOrder(root);
    }

    @Test
    public void test2(){
        Tnode root = new Tnode();
        insert( root, 5);
        insert( root, 1);
        insert( root, 4);
        System.out.println(root);
    }
    //初始化二叉树
    public Tnode InitializeTree(int [] arr){
        Tnode root = null;
        for (int i = 0; i < arr.length; i++) {
            if (i==0){
                //初始化root
                root= new Tnode(arr[i]);
                continue;
            }
            insert(root,arr[i]);
        }
        return root;
    }

    //初始化二叉树
    public void  InitializeTree2(int [] arr,Tnode tnode){
        for (int i = 0; i < arr.length; i++) {
            if (i==0){
                //初始化root
                tnode.data = arr[i];
                continue;
            }
            insert(tnode,arr[i]);
        }
    }

    //二叉树插入
    public void insert(Tnode root,int data){
        Tnode tnode = new Tnode(data);//需要插入的数据
        Tnode current = root;//当前节点
        while (true){
                Tnode parent = current;//记录当前节点
                if (data<current.data){
                    //比当前节点小往左孩子走
                    current = current.lchild;
                    //如果寻找到叶子节点
                    if (current==null){
                        //插入在左端
                        parent.lchild = tnode;
                        break;//跳出循环
                    }
                }else {//往当前节点的右边寻找
                    current = current.rchild;
                    if (current==null){
                        parent.rchild = tnode;
                        break;//跳出循环
                    }
                }
        }
    }

    //中序递归遍历
    public void InOrder(Tnode tnode){
        if (tnode!=null){
            InOrder(tnode.lchild);
            System.out.print(tnode.data+" ");
            InOrder(tnode.rchild);
        }
    }
}
