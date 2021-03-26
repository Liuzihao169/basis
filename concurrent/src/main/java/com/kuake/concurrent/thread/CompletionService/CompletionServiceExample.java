package com.kuake.concurrent.thread.CompletionService;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuzihao
 * @create 2021-01-19-16:46
 * 使用多线程组提交
 */
public class CompletionServiceExample {
    public static void main(String[] args) {
        ExecutorService excutor = Executors.newFixedThreadPool(5);
        boolean flag = true;
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService(excutor);
        completionService.submit(()-> { Thread.sleep(10000) ;return "OK" + Thread.currentThread().getName();});
        completionService.submit(()-> { Thread.sleep(5000) ;return "OK1" + Thread.currentThread().getName();});
        completionService.submit(()-> { Thread.sleep(1000) ;
        throw new RuntimeException("发生错误"); });
        completionService.submit(()-> { Thread.sleep(3000) ;return "OK3" + Thread.currentThread().getName();});

        for (int i = 0; i<=3; i++) {
            try {
                String s = completionService.take().get();
                System.out.println(s);
            } catch (Exception e) {
                System.out.println("任务执行出错");
            }
        }
    }
}
