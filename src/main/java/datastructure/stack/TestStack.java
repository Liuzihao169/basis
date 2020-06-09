package datastructure.stack;

/**
 * @author hao
 * @create 2019-07-25 ${TIM}
 */
public class TestStack {
    public static void main(String[] args) {
        SqStack stack = new SqStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        stack.pop();
    }
}
