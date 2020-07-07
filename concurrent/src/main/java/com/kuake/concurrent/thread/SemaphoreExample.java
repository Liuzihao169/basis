package com.kuake.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author liuzihao
 * @create 2020-04-18-21:08
 * 测试countdownlatch
 */
@Slf4j
public class SemaphoreExample {

    public static void main(String[] args) throws Exception {
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            final  int num = i;
            new Thread(()->{
                try {
                    if (semaphore.tryAcquire()) {
                        Thread.sleep(1000);
                        log.info("this thread id is {} and i is {} ",Thread.currentThread().getName(),num);
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }
}
