package com.kuake.concurrent.thread.CompletionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuzihao
 * @create 2021-01-21-14:51
 */
public class CompletionServiceExample3 {
    public static void main(String[] args) throws Exception{
        ExecutorService excutor = Executors.newFixedThreadPool(5);
        excutor.execute(()-> System.out.println(Thread.currentThread().getName()));
        excutor.execute(()-> System.out.println(Thread.currentThread().getName()));
        excutor.execute(()-> System.out.println(Thread.currentThread().getName()));
        excutor.execute(()->{
            System.out.println(Thread.currentThread().getName());
            throw new RuntimeException("123");
        });
        Thread.sleep(1000);
        System.out.println("123123123");
    }
}
