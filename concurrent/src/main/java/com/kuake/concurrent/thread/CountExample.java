package com.kuake.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

/**
 * @author liuzihao
 * @create 2020-04-13-19:28
 */
@Slf4j
public class CountExample {
   private static int count = 0;
   private  static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                add();
            }).start();
        }
        Thread.sleep(1000);
        log.info("count is {}",count);
    }

    private static  void add() {
        try {
            Thread.sleep(100);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
