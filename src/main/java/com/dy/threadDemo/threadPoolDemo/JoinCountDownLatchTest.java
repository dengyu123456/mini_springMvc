package com.dy.threadDemo.threadPoolDemo;

public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("th1");
            }
        }, "th1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("th2");
            }
        }, "th2");

        thread2.start();
        thread1.start();
        thread2.join();
        thread1.join();
        System.out.println("h");
    }
}
