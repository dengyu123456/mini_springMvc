package com.dy.threadDemo.threadPoolDemo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
    static ExecutorService thredPool = Executors.newFixedThreadPool(2);
    static Exchanger<String> exge = new Exchanger<String>();

    public static void main(String[] args) {
        thredPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "A";
                try {
                    String exchange = exge.exchange(A);
                    System.out.println("这是A线程:" + exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thredPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "B";
                try {
                    String exchange = exge.exchange(B);
                    System.out.println("这是B线程:" + exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
