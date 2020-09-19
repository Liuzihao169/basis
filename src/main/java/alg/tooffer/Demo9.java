package alg.tooffer;

import datastructure.stack.SqStack;
import org.junit.Test;

/**
 * @author liuzihao
 * @create 2020-09-16-21:43
 * 题目9：用两个栈实现队列
 */
public class Demo9 {

   static class Myqueue {
       SqStack s1 = new SqStack();
       SqStack s2 = new SqStack();

       public void appendTail(String data) {
           s1.push(data);
       }

       private String deleteHead() {
           if (s2.isEmpty()) {
               while (!s1.isEmpty()) {
                   s2.push(s1.pop());
               }
           }

           return (String) s2.pop();
       }
   }

    /**
     *
     */
    @Test
    public void test() {
        Myqueue myqueue = new Myqueue();
        myqueue.appendTail("1");
        myqueue.appendTail("2");
        myqueue.appendTail("3");
        myqueue.appendTail("4");
        myqueue.appendTail("5");
        String s = myqueue.deleteHead();
        System.out.println(s);
        myqueue.appendTail("6");
        System.out.println(myqueue.deleteHead());
    }
}
