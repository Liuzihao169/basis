package datastructure.tree;

import java.util.Objects;

/**
 * @author liuzihao
 * @create 2020-09-13-11:27
 * 带有父亲节点的 node
 */
public class Tpnode<T> {
    /**
     * 数据
     */
    public T data;
    /**
     * 左孩子
     */
    public Tpnode lchild;
    /**
     * 右孩子
     */
    public Tpnode rchild;

    /**
     * 父亲节点
     */
    public Tpnode fNode;

    public Tpnode(T data) {
        this.data = data;
    }

    public Tpnode() {
    }

    @Override
    public String toString() {
        return "Tnode{" +
                "data=" + data +
                ", lchild=" + lchild +
                ", rchild=" + rchild +
                '}';
    }

    /**
     * 重写方法进行比较
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tpnode<?> tpnode = (Tpnode<?>) o;
        return data.equals(tpnode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
