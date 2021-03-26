package com.kuake.concurrent.thread.CompletionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author liuzihao
 * @create 2021-01-20-16:15
 */
public class CompletionServiceExample1 {
    public static void main(String[] args) throws Exception{
        ExecutorService completionService = Executors.newFixedThreadPool(5);

        Future<String> submit = completionService.submit(() -> {
            Thread.sleep(10000);
            return "OK" + Thread.currentThread().getName();
        });
        Future<String> submit1 = completionService.submit(() -> {
            Thread.sleep(1000);
            return "OK1" + Thread.currentThread().getName();
        });
        Future<String> submit2 = completionService.submit(() -> {
            Thread.sleep(1000);
            throw new RuntimeException("发生错误");
        });


        submit2.get();
        System.out.println("123");
    }
}
