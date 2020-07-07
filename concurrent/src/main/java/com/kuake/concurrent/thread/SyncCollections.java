package com.kuake.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzihao
 * @create 2020-04-17-20:06
 */
@Slf4j
public class SyncCollections {
    private  static Collection<String> list = Collections.synchronizedCollection(new ArrayList<String>());

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                add();
            }).start();
        }
//        Thread.sleep(1000);
        log.info("list size is {}",list.size());
    }

    private static  void add() {
        try {
            Thread.sleep(100);
            list.add("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
