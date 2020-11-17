package alg.tooffer;

import datastructure.stack.SqStack;
import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-11-09-21:38
 * 面试题目30：包含main函数的栈
 * main 函数：能够获得栈当中最小的元素
 */
public class Demo30 extends DemoBase {
    /**
     * 解题思路：
     * 利用辅助栈 每次都存栈中最小都元素
     * 调用main 函数都时候就从辅助栈中取数据
     */
    @Test
    public void test(){
        mianStack mianStack = new mianStack();
        mianStack.push(5);
        System.out.println(mianStack.main());
        mianStack.push(4);
        mianStack.push(2);
        mianStack.push(1);
        System.out.println(mianStack.main());
    }
}
class mianStack extends SqStack<Integer>{
    private SqStack<Integer> sqStack  = new SqStack();

    @Override
    public void push(Integer o ) {
        if (null == o) {
            throw new RuntimeException("数据不合法");
        }
        super.push(o);
        Integer top = sqStack.getTop();
        if (null == top) {
            sqStack.push(o);
        }else {
            if (top.compareTo(o) < 1) {
                sqStack.push(top);
            }else {
                sqStack.push(o);
            }
        }
    }

    @Override
    public Integer pop(){
        Integer pop = super.pop();
        sqStack.pop();
        return pop;
    }

    public Integer main() {
        return sqStack.getTop();
    }
}
