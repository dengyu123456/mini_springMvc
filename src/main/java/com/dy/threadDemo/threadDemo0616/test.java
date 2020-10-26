package com.dy.threadDemo.threadDemo0616;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class test {
    static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
    static List<Integer> list = new CopyOnWriteArrayList<>();
    ReentrantLock lock = new ReentrantLock();
    static CountDownLatch countDownLatch = new CountDownLatch(2);
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

        AtomicInteger atomicInteger = new AtomicInteger();
        //int andIncrement = atomicInteger.getAndIncrement();
        atomicInteger.set(1);
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.compareAndSet(2, 1));
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                map.put("1", "1");
                list.add(1);
                list.get(0);
                LockSupport.park();
                LockSupport.park(this);

                Iterator<Integer> iterator = list.iterator();
                iterator.hasNext();
                iterator.next();
                System.out.println("这是一个线程");
            }
        });
        threadOne.start();
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                map.put("1", "1");
                list.add(1);
                list.get(0);
                LockSupport.park();
                LockSupport.park(this);
                LockSupport.unpark(threadOne);
                Iterator<Integer> iterator = list.iterator();
                iterator.hasNext();
                iterator.next();
                System.out.println("这是一个线程");
            }
        });
        threadOne.start();
    }
}
