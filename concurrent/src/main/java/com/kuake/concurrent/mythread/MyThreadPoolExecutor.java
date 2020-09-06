package com.kuake.concurrent.mythread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author liuzihao
 * @create 2020-08-02-15:44
 */
@Slf4j
public class MyThreadPoolExecutor  extends ThreadPoolExecutor {


    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        log.info("开始执行任务之前");
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        log.info("执行任务结束之后");
        super.afterExecute(r, t);
    }

    @Override
    protected void terminated() {
        log.info("关闭线程池");
        super.terminated();
    }
}
