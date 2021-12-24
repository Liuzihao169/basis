package com.kuake.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author liuzihao
 * @create 2020-04-23-14:10
 */
@Slf4j
public class FutureTaskExample1 {

    static class Mycallable implements Callable<String> {
        public Mycallable(int time,int flag){
            this.time = time;
            this.flag =flag;
        }
        private int time ;
        private int flag;
        @Override
        public String call() throws Exception {
            Thread.sleep(time);
            log.info("sleep time is {} submit{}",time,flag);
            return "some thing is doing"+time;
        }
    }

    public static void main1(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        log.info("this is main");
        Future<String> submit = executorService.submit(new Mycallable(100,0));
        executorService.execute(()->{
            System.out.println("123123123");
        });
        Future<String> submit1 = executorService.submit(new Mycallable(100,1));
        Future<String> submit2 = executorService.submit(new Mycallable(100,2));
        Future<String> submit3= executorService.submit(new Mycallable(1000,3));
        // 获取结果就必须等待
        log.info("this is {}submit"+0,submit.get());
        log.info("this is {}submit"+1,submit1.get());
        log.info("this is {}submit"+2,submit2.get());
        log.info("this is 000000");
        log.info("this is {}submit"+3,submit3.get());
        System.out.println("-------------------");
        executorService.shutdown();
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        log.info("this is main");
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Future<String> submit = executorService.submit(()->{
            Thread.sleep(1000);
            int i = 1/0;
            return "123";
        });
        submit.get();
        Thread.sleep(3000);
        System.out.println("主线程执行完毕.....");

    }

}
