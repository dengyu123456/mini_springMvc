package com.dy.threadDemo.threadPoolDemo;

import org.junit.Test;

public class TwinsLockTest {
    @Test
    public void test() {
        TwinsLock twinsLock = new TwinsLock();
        class Worker extends Thread {

            @Override
            public void run() {
                twinsLock.lock();
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        twinsLock.unlock();
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }

}
