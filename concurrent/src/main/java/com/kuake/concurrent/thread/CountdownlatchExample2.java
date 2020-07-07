package com.kuake.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzihao
 * @create 2020-04-18-21:08
 * 测试countdownlatch
 */
@Slf4j
public class CountdownlatchExample2 {

    public static void main(String[] args) throws Exception {
        // 设置挡板数量
        final CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 9; i++) {
            final  int num = i;
            new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    log.info("this thread id is {} and i is {} ",Thread.currentThread().getName(),num);
                    latch.countDown();
                }

            }).start();
        }

        latch.await(400, TimeUnit.MILLISECONDS);
        log.info("fish and latch count is {}",latch.getCount());
    }
}
