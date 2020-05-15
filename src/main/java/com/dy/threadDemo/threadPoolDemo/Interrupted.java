package com.dy.threadDemo.threadPoolDemo;

import java.awt.image.BufferStrategy;

public class Interrupted {

    public static void main(String[] args) {
        Thread sleepRunner = new Thread(new SleepRunner(), "sleepRunner");
        sleepRunner.setDaemon(true);
        Thread buysRuuer = new Thread(new BuysRuuer(), "buysRuuer");
        buysRuuer.setDaemon(true);
        sleepRunner.start();
        buysRuuer.start();
        SleepUtils.second(5);
        sleepRunner.interrupt();
        buysRuuer.interrupt();
        System.out.println("SleepThread interrupted is " + sleepRunner.isInterrupted());
        System.out.println("BusyThread interrupted is " + buysRuuer.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
    }

    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    static class BuysRuuer implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
