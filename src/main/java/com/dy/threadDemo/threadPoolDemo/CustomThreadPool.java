package com.dy.threadDemo.threadPoolDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 自定义线程池
 */
public class CustomThreadPool<job extends Runnable> implements CustomThreadPoolIntf<job> {
    //初始化线程池，线程数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    // 线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    //工作列表
    private final LinkedList<job> jobs = new LinkedList();
    //工作者线程
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());


    //初始化线程池
    public CustomThreadPool() {
        //创建工作者，放入工作者队列中
        for (int i = 0; i < DEFAULT_WORKER_NUMBERS; i++) {
            Worker worker = new Worker();
            Thread thread = new Thread(worker, "1");
            workers.add(worker);
            thread.notify();
        }

    }

    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void addWorkers(int num) {

    }

    @Override
    public void removeWorker(int num) {

    }

    @Override
    public int getJobSize() {
        return 0;
    }


    //工作者线程，实际的工作由工作者线程去执行
    static class Worker implements Runnable {
        @Override
        public void run() {
            System.out.println("worker线程");
        }
    }

    public static void main(String[] args) {
//        Worker worker = new Worker();
//        Thread thread = new Thread(worker, "线程名称");
//        thread.start();

        ReadWriteLock readWriteLock = new ReadWriteLock() {
            @Override
            public Lock readLock() {
                return null;
            }

            @Override
            public Lock writeLock() {
                return null;
            }
        };

        ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
        ReentrantLock reentrantLock=new ReentrantLock();
    }

    static class A {
        public int a;

    }

    static class B extends A {
        public B() {
            super.a = 10;
        }
    }
}
