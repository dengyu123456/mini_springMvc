package com.dy.threadDemo.threadPoolDemo;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread await = new Thread(new Await(), "await");
        Thread signal = new Thread(new Signal(), "signal");
        await.start();
        signal.start();

    }

    static class Await implements Runnable {
        boolean run = true;

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("等待中");
                condition.await();
                System.out.println("第一次等待结束");
                System.out.println("第二次等待");
                condition.awaitNanos(10000000000L);
                System.out.println("第二次等待结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    static class Signal implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                LockSupport.parkNanos(10000000000L);
                condition.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }

        }
    }

}
