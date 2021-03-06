package com.dy.threadDemo.threadPoolDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {


    //reset()重置计数器
    //await会将计算器减一并且会阻塞线程，计数器等于0时释放之前阻塞的线程
    //isBroken方法：判断线程是否中断

    //如下构造方法，当到达同步屏障时会先执行A线程
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("th1");

            }
        }, "th1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("th2");

            }
        }, "th2");


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("th3");

            }
        }, "th3");
        thread1.start();
        thread2.start();
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println("A");
        }
    }
}
