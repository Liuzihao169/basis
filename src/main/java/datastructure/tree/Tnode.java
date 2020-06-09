package datastructure.tree;

/**
 * @author hao
 * @create 2019-07-29 ${TIM}
 * 树的节点
 */
public class Tnode {
    int data;//数据
    Tnode lchild;//左孩子
    Tnode rchild;//右孩子

    public Tnode(int data) {
        this.data = data;
    }

    public Tnode() {
    }

    @Override
    public String toString() {
        return "Tnode{" +
                "data=" + data +
                ", lchild=" + lchild +
                ", rchild=" + rchild +
                '}';
    }
}
