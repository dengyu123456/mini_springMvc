package com.dy.threadDemo.threadPoolDemo;

/**
 *
 */
public class Daemon {
    public static Object lock=new Object();
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunable());
        //thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunable implements Runnable {
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(1111);
                try {
                    lock.wait();
                    System.out.println(33333);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.notify();
                    System.out.println(2222);
                }
            }
            //SleepUtils.second(10);
            System.out.println("这是守护线程");
        }
    }
}
