package com.dy.threadDemo.threadPoolDemo;

public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        //创建两个线程
        Runer one = new Runer();
        Thread oneThred = new Thread(one, "one");
        oneThred.start();
        SleepUtils.second(1);
        oneThred.interrupt();
        Runer two = new Runer();
        Thread twoThred = new Thread(two, "two");
        twoThred.start();
        SleepUtils.second(1);
        two.chanl();
    }

    static class Runer implements Runnable {
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i + Thread.currentThread().getName());
        }

        public void chanl() {
            on = false;
        }
    }
}
