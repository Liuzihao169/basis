package datastructure.queue;


import datastructure.stack.Node;

/**
 * @author hao
 * @create 2019-07-25 ${TIM}
 * 队列 链式存储 单链表
 * 带有头节点版本 设置头指针尾部指针
 * 队头 front  出队列(每次改变头指针即可)
 * 队尾 rear   入队列(尾部添加)
 * 判空条件
 */
public class Qqueue<T> {

    //队头指针
   private Node<T> front;
    //队尾指针
    private Node<T> rear;

    //入队列
   public void  EnQueue(Object o){
       //第一次添加
       if (front == null) {
           Node head = new Node();//建立头节点
           Node front = new Node();//建立头指针 front
           Node rear = new Node();//建立尾指针 rear;
           //建立关系
           front.next = head;
           rear.next = head;

           this.front = front;
           this.rear = rear;
       }
       Node node = new Node(o);
       rear.next.next = node;
       rear.next = node;
   }

   //出队 只需要改变头节点
    public T DeQueue(){
       if(isEmpty()) throw  new RuntimeException("空队列");

        //头节点
        Node head  =  front.next;
       //出队操作
        //目标节点 p
        Node<T> p = head.next;
        head.next =p.next;

        //释放p
        p.next = null;

        //如果删除是最后一个节点
        if (head.next==null) this.rear.next = this.front.next;

        return p.data;
    }

    //获得队头
    public T getFront(){
        if(isEmpty()) throw  new RuntimeException("空队列");
        return (T) this.front.next.next.data;
    }

    //判断是否为空队列
    public boolean isEmpty(){
       return  (this.rear.next== this.front.next);
    }
}
