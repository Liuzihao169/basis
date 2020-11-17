package alg.tooffer;

import datastructure.stack.SqStack;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-11-12-21:16
 * 面试题31：栈的压入于弹出序列
 * 入栈{1,2,3,4,5}
 * 出栈{4,5,3,2,1}
 */
public class Demo31 extends DemoBase {
    /**
     * 解题思路:
     * 利用逆过程
     * 根据出队序列，压入入队序列，看是否合理
     */
    @Test
    public void test() {
        List<Integer> inStackOrder = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> outStackOrder = Arrays.asList(4, 5, 3, 2, 1);
        List<Integer> outStackOrder2 = Arrays.asList(4, 3, 5, 1, 2);
        boolean match = isMatch(inStackOrder, outStackOrder);
        boolean match1 = isMatch(inStackOrder, outStackOrder2);
        System.out.println(match);
        System.out.println(match1);
    }

    private boolean isMatch(List<Integer> inStackOrder, List<Integer> outStackOrder) {
        if (null == inStackOrder || null == outStackOrder) {
            return false;
        }
        if (inStackOrder.size() != outStackOrder.size()) {
            return false;
        }
        int outIndex = 0;
        int inIndex = 0;
        SqStack<Integer> sqStack = new SqStack<>();
        while (true) {
            if (outIndex >= outStackOrder.size()) {
                return true;
            }
            while (!outStackOrder.get(outIndex).equals(sqStack.getTop())) {
                if (inIndex >= inStackOrder.size()) {
                    return false;
                }
                sqStack.push(inStackOrder.get(inIndex++));
            }
            sqStack.pop();
            outIndex++;
        }
    }
}
