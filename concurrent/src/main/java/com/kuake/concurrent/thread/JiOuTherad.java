package com.kuake.concurrent.thread;

/**
 * @author liuzihao
 * @create 2021-03-09-20:31
 */
public class JiOuTherad {
   public   int  count = 0;

    public static void main(String[] args) throws Exception {

        JiOuTherad jiOuTherad = new JiOuTherad();

        Thread a = new Thread(new RunablaJiOu1(jiOuTherad));

        Thread b = new Thread(new RunablaJiOu2(jiOuTherad));

        a.setName("thread-A");
        b.setName("thread-B");
        a.start();

        b.start();
        a.join();



        b.join();


    }
}

class RunablaJiOu1 implements Runnable {

    JiOuTherad jiOuTherad;

    public RunablaJiOu1(JiOuTherad start) {
        this.jiOuTherad = start;
    }

    @Override
    public void run() {
        while (jiOuTherad.count <= 100) {
            synchronized (JiOuTherad.class){
                if (jiOuTherad.count %2 !=0) {
                    System.out.println(Thread.currentThread().getName() + "抢到锁...." + jiOuTherad.count);
                    jiOuTherad.count++;
                    JiOuTherad.class.notify();

                }else {
                    try {
                        JiOuTherad.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

class RunablaJiOu2 implements Runnable {

    JiOuTherad jiOuTherad;

    public RunablaJiOu2(JiOuTherad start) {
        this.jiOuTherad = start;
    }

    @Override
    public void run() {
        while (jiOuTherad.count <= 100) {
            synchronized (JiOuTherad.class) {
                if (jiOuTherad.count %2 ==0){
                    System.out.println(Thread.currentThread().getName() + "抢到锁...." + jiOuTherad.count);
                    jiOuTherad.count++;
                    JiOuTherad.class.notify();

                }else {
                    try {
                        JiOuTherad.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }


        }
    }
}


