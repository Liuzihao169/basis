package com.kuake.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author liuzihao
 * @create 2020-08-02-10:54
 */
public class DeadLock {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 任务A
        executorService.submit(()->{

            // 任务B
            Future<String> submit = executorService.submit(() -> {
                return " one things";
            });


            return submit.get();
        });

        // 如果是线程数量小 该线程会被饥饿
        executorService.execute(()->{
            System.out.println("其他任务");
        });

    }

}
