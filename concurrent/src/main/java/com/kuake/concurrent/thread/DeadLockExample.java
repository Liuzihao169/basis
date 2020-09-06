package com.kuake.concurrent.thread;



/**
 * @author liuzihao
 * @create 2020-08-03-21:37
 */
public class DeadLockExample {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    private static void doSomethings() {
        synchronized (lockA) {
            synchronized (lockB) {
                System.out.println("1-----");
            }
        }
    }


    private static void doSomethings2() {
        synchronized (lockB) {
            synchronized (lockA) {
                System.out.println("2-----");
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread.currentThread().setName(" this is my ");

        new Thread(()->{
            Thread.currentThread().setName("do 1");
            for (int i = 0; i < 100; i++) {
                doSomethings();
            }
        }).start();

        new Thread(()->{
            Thread.currentThread().setName("do 2");
            for (int i = 0; i < 100; i++) {
                doSomethings2();
            }

        }).start();

        Thread.currentThread().join();
    }

}
