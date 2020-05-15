package com.dy.threadDemo.threadPoolDemo;

/**
 *   synchronized(对象) {
 *     while(条件不满足) {
 *     对象.wait();
 *   }对应的处理逻辑 }
 *
 *   synchronized(对象) {
 *      改变条件
 *      对象.notifyAll();
 *      }
 */
public class WaitNotify {
    private static Object lock = new Object();

    private static Boolean flag = true;

    public static void main(String[] args) {
        Thread waitThread = new Thread(new WaitRuner(), "wait");
        waitThread.start();
        Thread notifyThread = new Thread(new NotifyRuner(), "notify");
        notifyThread.start();
    }

    static class WaitRuner implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(System.currentTimeMillis() + Thread.currentThread().getName());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("第二次唤醒");
            }
        }
    }

    static class NotifyRuner implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(System.currentTimeMillis() + Thread.currentThread().getName());
                lock.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = false;
            }
        }
    }
}

 /*
 从4.3.2节中的WaitNotify示例中可以提炼出等待/通知的经典范式，该范式分为两部分，分 别针对等待方（消费者）和通知方（生产者）。 等待方遵循如下原则。 1）获取对象的锁。 2）如果条件不满足，那么调用对象的wait()方法，被通知后仍要检查条件。 3）条件满足则执行对应的逻辑。 对应的伪代码如下。 synchronized(对象) { while(条件不满足) { 对象.wait(); }对应的处理逻辑 }通知方遵循如下原则。 1）获得对象的锁。 2）改变条件。 3）通知所有等待在对象上的线程。 对应的伪代码如下。 synchronized(对象) { 改变条件 对象.notifyAll(); }
  */