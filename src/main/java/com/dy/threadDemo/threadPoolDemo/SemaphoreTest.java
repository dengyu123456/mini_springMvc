package com.dy.threadDemo.threadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    /**
     * Semaphore还提供一些其他方法，具体如下。
     * ·intavailablePermits()：返回此信号量中当前可用的许可证数。
     * ·intgetQueueLength()：返回正在等待获取许可证的线程数。
     * ·booleanhasQueuedThreads()：是否有线程正在等待获取许可证。
     * ·void reducePermits（int reduction）：减少reduction个许可证，是个protected方法。
     * ·Collection getQueuedThreads()：返回所有等待获取许可证的线程集合，是个protected方 法。
     */
    private static final int THREAD_COUNT = 30;
    static ExecutorService thredPool = Executors.newFixedThreadPool(THREAD_COUNT);

    static Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            thredPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("hhhhhhhhhhhh");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }

                }
            });
        }
    }
}
