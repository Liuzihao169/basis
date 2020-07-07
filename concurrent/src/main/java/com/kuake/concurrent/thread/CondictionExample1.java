package com.kuake.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuzihao
 * @create 2020-04-22-19:58
 */
@Slf4j
public class CondictionExample1 {


    public static void main(String[] args) {
         ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            lock.lock();
            log.info("this is thread {} wait signal",Thread.currentThread().getName());
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("this is thread {} get signal",Thread.currentThread().getName());
            lock.unlock();
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            log.info("this is thread {} get lock",Thread.currentThread().getName());
            condition.signalAll();//唤醒在condition当中的线程,将移动到AQS队列当中，参加锁的竞争
            log.info("this is thread {} send signal",Thread.currentThread().getName());

            lock.unlock();
        }).start();
    }
}
