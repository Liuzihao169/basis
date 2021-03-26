package diy;

/**
 * @author hao
 * @create 2019-07-15 ${TIM}
 */
//定义一个节点
public class Node<T> {
    public Node prefix; //前一个节点
    public Node sufix; //后一个节点
    public T data; //数据

    public Node(T data) {
        this.data =data;
    }

    public Node(Node prefix, Node sufix, T data) {
        this.prefix = prefix;
        this.sufix = sufix;
        this.data = data;
    }
}
