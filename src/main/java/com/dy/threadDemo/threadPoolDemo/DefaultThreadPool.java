package com.dy.threadDemo.threadPoolDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //最大线程数量 默认10
    int MaxNum = 10;
    //默认线程为5
    int DefaultNum = 5;

    //工作队列
    private List<Worder> worders = Collections.synchronizedList(new ArrayList<Worder>());
    //任务队列
    private final LinkedList<Job> jobs = new LinkedList<Job>();

    AtomicInteger atomicInteger = new AtomicInteger();

    public DefaultThreadPool() {
        initializeWokers(DefaultNum);
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    //初始化工作者线程
    private void initializeWokers(int num) {
        for (int i = 0; i < num; i++) {
            Worder worder = new Worder();
            Thread thread = new Thread(worder, atomicInteger.incrementAndGet() + "");
            worders.add(worder);
            thread.start();
        }
    }

    @Override
    public void shutdown() {
        for (Worder worder : worders) {
            worder.shutdown();
        }
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

    public int getWorks() {
        return worders.size();
    }

    //工作者对象
    class Worder implements Runnable {
        private volatile boolean runing = true;

        @Override
        public void run() {
            while (runing) {
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Job job = jobs.removeFirst();
                    if (job != null) {
                        job.run();
                    }
                }
            }
        }

        public void shutdown() {
            runing = false;
        }
    }
}
