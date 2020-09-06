package com.kuake.concurrent.mythread;

import ch.qos.logback.classic.turbo.TurboFilter;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author liuzihao
 * @create 2020-08-02-15:51
 */
public class MyThreadPoolExecutorTest {

    @Test
    public void test1() throws Exception{
        Thread.currentThread().setName("mian-mioan");

    MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(
            5,
            10,
            5,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10));


    myThreadPoolExecutor.execute(
            ()-> {
                Thread.currentThread().setName("123123123");
                System.out.println("执行任务....");
            }
    );

        Future<?> submit = myThreadPoolExecutor.submit(new FutureTask<String>(() -> "123"));

        System.out.println(submit.cancel(true));


        Thread.sleep(3000l);
    }

    @Test
    public void test2() throws Exception{

        Thread.currentThread().setName("liuzihao");
        Thread.sleep(100000);

        System.out.println("main is end");
    }
}