package datastructure.queue;

/**
 * @author hao
 * @create 2019-07-26 ${TIM}
 * 测试循环队列
 */
public class TestSqueue {
    public static void main(String[] args) {
        SqQueue sqQueue = new SqQueue();
        for (int i = 0; i < 15; i++) {
            sqQueue.EnQueue(i);
        }
        System.out.println(sqQueue.rear+"========"+sqQueue.front);
        //输出长度
        System.out.println(sqQueue.QueueLength());
        System.out.println(sqQueue.isEmpty());
        //此时会报错 因为队列只能存放15个
        sqQueue.EnQueue(16);
    }
}
