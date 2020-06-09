package datastructure.stack;

/**
 * @author hao
 * @create 2019-07-25 ${TIM}
 */
public class Node {

    //不添加public默认访问权限是 包内可以访问
    public Object data;//数据
    public  Node next;//指向下一个节点

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
