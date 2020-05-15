package com.dy.threadDemo.threadPoolDemo;

public class VolatileTest {
    public static volatile int i = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new VolatileRun1());
        Thread thread2 = new Thread(new VolatileRun2());
        thread2.start();
        thread1.start();
        thread2.join();
        thread1.join();
        System.out.println(i);//2   预期值应该是6
    }
    static class VolatileRun1 implements Runnable {
        @Override
        public void run() {
            i = 5;
        }
    }
    static class VolatileRun2 implements Runnable {
        @Override
        public void run() {
            //i++;
            //模仿i++
            int a = i;
            SleepUtils.second(2);
            i = a + 1;
        }
    }
}
