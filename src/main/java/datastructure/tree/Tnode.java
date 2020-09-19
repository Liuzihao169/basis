package datastructure.tree;

/**
 * @author hao
 * @create 2019-07-29 ${TIM}
 * 树的节点
 */
public class Tnode {
    /**
     * 数据
     */
    public int data;
    /**
     * 左孩子
     */
    public Tnode lchild;
    /**
     * 右孩子
     */
    public Tnode rchild;

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
