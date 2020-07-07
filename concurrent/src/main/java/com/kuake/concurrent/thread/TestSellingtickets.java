package com.kuake.concurrent.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuzihao
 * @create 2020-04-11-20:48
 */

 class Sellingtickets implements Runnable {

    private AtomicInteger num = new AtomicInteger(100) ;
    @Override
    public void run() {
        // 对100张票进行售卖
        while (num.get()>0) {
            if (num.get() > 0) {
                // 模拟网络延迟
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" 售卖第"+ num.getAndDecrement() +"张票");
        }
    }
}

public class TestSellingtickets {
    public static void main(String[] args) {
        // 新建一个售票窗口
        Sellingtickets sellingtickets = new Sellingtickets();
        // 测试3个售票员进行买票
        for (int i = 0; i < 3; i++) {
            new Thread(sellingtickets,"第"+i+"个售票").start();
        }
    }

}