package com.kuake.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuzihao
 * @create 2020-04-17-19:32
 */
@Slf4j
public class TestStringBuild {
    private static int count = 0;
//    private  static StringBuilder stringBuilder = new StringBuilder();
    private  static StringBuffer stringBuffer = new StringBuffer();
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                add();
            }).start();
        }
        Thread.sleep(5000);
        log.info("StringBulider size  is {}",stringBuffer.length());
    }

    private static  void add() {
        try {
            Thread.sleep(100);
            stringBuffer.append(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
