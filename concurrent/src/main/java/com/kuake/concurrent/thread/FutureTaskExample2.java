package com.kuake.concurrent.thread;

import lombok.extern.slf4j.Slf4j;
import sun.util.locale.provider.LocaleServiceProviderPool;

import java.util.concurrent.*;

/**
 * @author liuzihao
 * @create 2020-04-23-14:10
 */
@Slf4j
public class FutureTaskExample2 {

    static class Mycallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "some thing is doing";
        }
    }

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(()->{
            log.info("start callback....");
            Thread.sleep(3000);
            return "some things ";
        });

        new Thread(futureTask).start();
        log.info("this callback is {}",futureTask.get());
        log.info("main.....");

    }
}
