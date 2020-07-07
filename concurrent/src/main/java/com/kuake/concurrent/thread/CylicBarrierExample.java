package com.kuake.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author liuzihao
 * @create 2020-04-18-21:08
 * CylicBarrier
 */
@Slf4j
public class CylicBarrierExample {

    private final static CyclicBarrier CYLIC_BARRIER = new CyclicBarrier(5);
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            final  int num = i;
            Thread.sleep(1000);
            new Thread(()->{
                try {
                 ready(num);
               } catch (Exception e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
    public static void ready(int num) throws Exception {
        log.info(" ready this thread id is {} and i is {} ",Thread.currentThread().getName(),num);
        CYLIC_BARRIER.await();
        log.info(" continue .... this thread id is {} and i is {} ",Thread.currentThread().getName(),num);
    }
}
