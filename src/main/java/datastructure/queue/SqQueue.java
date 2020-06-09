package datastructure.queue;

/**
 * @author hao
 * @create 2019-07-25 ${TIM}
 * 循环队列 顺序存储 逻辑环状
 * 牺牲一个容量：当队头指针的下一位 是队尾指针装满。
 */
public class SqQueue {

    int front;//队头
    int rear;//队尾
    final static int  Queue_DEFAULT_SIZE = 16;//默认循环队列的容量 实际打小 max-1
    Object [] obj = new Object[Queue_DEFAULT_SIZE];

    //入队
    public void EnQueue(Object o){
        if(isEnough()) throw  new RuntimeException("循环队列满");
        //存入数据
        obj[rear] = o;
        //指针前移
        rear = (rear +1)%Queue_DEFAULT_SIZE;
    }

    //出队列
    public Object DeQueue(){
        if (isEmpty()) throw new RuntimeException("空队列");
        Object o = obj[front];
        obj[front] = null;
        //指针前移
        front = (front +1)%Queue_DEFAULT_SIZE;
        return o;
    }
    //长度
    public int QueueLength(){
        return (rear - front +Queue_DEFAULT_SIZE)%Queue_DEFAULT_SIZE;
    }
    //判满
    public boolean isEnough(){
        return (front-rear+Queue_DEFAULT_SIZE)%Queue_DEFAULT_SIZE==1;
    }
    //判空
    public boolean isEmpty(){
         return front==rear;
    }
}
