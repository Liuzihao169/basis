package alg.other;


import java.util.LinkedList;

/**
 * @author liuzihao
 * @create 2021-10-13-22:00
 */
public class Offer09 {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }


}

class CQueue {
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;


    public CQueue() {
        /**
         * 栈一:用于入队列
         */
        stack1 = new LinkedList<>();

        /**
         * 栈二：用于出队列
         */
        stack2 = new LinkedList<>();
    }

    /**
     * 入队尾
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 删除头
     * @return
     */
    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
