package com.dy.threadDemo.threadPoolDemo;

import java.util.concurrent.CountDownLatch;

public class DefaultThreadPoolTest {
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        DefaultThreadPool pool = new DefaultThreadPool();
        int num = 10;
//        end = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            test test = new test(i);
            pool.execute(test);
        }
        System.out.println(pool.getWorks());
//        start.countDown();
//        end.await();
    }

    static class test implements Runnable {
        private int i;

        public test(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                //start.await();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // end.countDown();
            System.out.println(i);

        }
    }
}
