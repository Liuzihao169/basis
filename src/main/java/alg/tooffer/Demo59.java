package alg.tooffer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liuzihao
 * @create 2021-09-26-08:21
 * 面试题目59：
 * 题目一：队列的最大值
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口中的最大值
 * 例如：如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 滑动窗口3
 * 那么就存在6个滑动窗口，的最大值，4,4,6,6,6,5
 */
public class Demo59 extends DemoBase {

    /**
     * 方式一：暴力破解法
     *
     * 方式二：利用一个 双端队列，来存储
     *  1、队头存储最最大的数据，
     *  2、如果当一个数字与当前处理的数字角标 大于等于滑动窗口则需要退出出该 数字
     *
     * offer()：添加元素，如果队列已满直接返回 false，队列未满则直接插入并返回 true；
     * poll()：删除并返回队头元素，当队列为空返回 null；
     * add()：添加元素，此方法是对 offer 方法的简单封装，如果队列已满，抛出 IllegalStateException 异常；
     * remove()：直接删除队头元素；
     * put()：添加元素，如果队列已经满，则会阻塞等待插入；
     * take()：删除并返回队头元素，当队列为空，则会阻塞等待；
     * peek()：查询队头元素，但不会进行删除；
     * element()：对 peek 方法进行简单封装，如果队头元素存在则取出并不删除，如果不存在抛出 NoSuchElementException 异常。
     */

    @Test
    public void test(){

        int [] arr =  new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int slidingLength = 3;


        Deque<Integer> deque = new ArrayDeque<>();
        //initQueue(deque);


        for (int i = 0; i < arr.length; i++) {

            /**
             * 去除过期的数据
             */
            Integer peek = deque.peekFirst();
            if (null !=peek) {
                if (i - peek >= slidingLength) {
                    deque.pollFirst();
                }
            }

            /*
             * 从队列尾去除全部比当前值小的数据
             */
            Integer lastIndex = deque.peekLast();
            while (!deque.isEmpty() && lastIndex!=null ){

                if (arr[i]<=arr[lastIndex]){
                    break;
                }
                deque.pollLast();
                lastIndex = deque.peekLast();

            }
            deque.add(i);
            if (i>= slidingLength - 1){
                System.out.print("当前最大值:");
                System.out.println(arr[deque.peek()] + "index:====>" + deque.peek());
            }
        }
    }
}
