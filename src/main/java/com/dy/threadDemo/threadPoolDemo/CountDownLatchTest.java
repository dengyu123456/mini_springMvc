package com.dy.threadDemo.threadPoolDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    //CountDownLatch countDown方法让CountDownLatch的N减一
    //await()方法的意思是当N大于0时会一直阻塞当前线程  只有N不大于0时，await方法才会失效
    //一个线程调用countDown方法happen-before，另外一个线程调用await方法。
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                countDownLatch.countDown();
                System.out.println(2);
            }
        }).start();
        countDownLatch.await();
        System.out.println(3);
    }
}
