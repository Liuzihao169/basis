package diy;

/**
 * @author hao
 * @create 2019-07-15 ${TIM}
 */
//定义一个节点
public class Node {
     Node prefix; //前一个节点
     Node sufix; //后一个节点
     Object data; //数据

    public Node() {
    }

    public Node(Node prefix, Node sufix, Object data) {
        this.prefix = prefix;
        this.sufix = sufix;
        this.data = data;
    }
}
