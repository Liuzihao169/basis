package datastructure.stack;

/**
 * @author hao
 * @create 2019-07-25 ${TIM}
 */
public class Node<T> {

    //不添加public默认访问权限是 包内可以访问
    public T data;//数据
    public  Node<T> next;//指向下一个节点

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}
