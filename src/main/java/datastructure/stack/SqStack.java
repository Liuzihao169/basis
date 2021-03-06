package datastructure.stack;

/**
 * @author hao
 * @create 2019-07-25 ${TIM}
 * 栈有两种表示方法：顺序存储和链式存储
 * 下面是链式存储
 */
public class SqStack<T> {
    /**
     * 栈顶端
     */
    private Node<T> top;
    /**
     * 栈尾
     */
    private Node<T> base;

    //进栈道
    public void push(T o) {
        Node node = new Node(o);
        //第一次进入栈道
        if (null == top) {
            node.next = null;
            this.top = node;
            this.base = node;
        } else {
            //插入的节点指向第一个节点
            node.next = this.top;
            this.top = node;
        }
    }

    //出栈
    public T pop() {
        if (null == this.top) {
            return null;
        }
        Node<T> node = this.top;
        this.top = top.next;
        node.next = null;//与后继无关联 等待被回收
        return node.data;
    }

    //获得栈顶元素
    public T getTop() {
        if (null == this.top) {
            return null;
        }
        return this.top.data;
    }

    //判空
    public boolean isEmpty() {
        return this.top == null;
    }

    //检查空
    public void checkStack() {
        if (this.top == null) throw new RuntimeException("空栈道");
    }
}
