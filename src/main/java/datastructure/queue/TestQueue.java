package datastructure.queue;

/**
 * @author hao
 * @create 2019-07-25 ${TIM}
 */
public class TestQueue {
    public static void main(String[] args) {
        Qqueue qqueue = new Qqueue();
        System.out.println(qqueue.isEmpty());
        qqueue.EnQueue(1);
        System.out.println(qqueue.isEmpty());
        qqueue.EnQueue(2);
        System.out.println(qqueue.isEmpty());
        qqueue.EnQueue(3);
        System.out.println(qqueue.isEmpty());
        qqueue.EnQueue(4);
        qqueue.EnQueue(5);
        qqueue.EnQueue(6);
        qqueue.EnQueue(7);
        System.out.println(qqueue.isEmpty());
        while (!qqueue.isEmpty()){
            System.out.println(qqueue.DeQueue());
        }

    }
}
