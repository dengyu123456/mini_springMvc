package com.dy.threadDemo.threadPoolDemo;

import com.dy.threadDemo.test.CountTask;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) {
        //LockSupport.park();//阻塞当前线程 park停车的意思
        //LockSupport.parkNanos(10000000000L);//阻塞当前线程Nanos纳秒
        long deadline= System.currentTimeMillis()+100000L;
        LockSupport.parkUntil(deadline);//阻塞当前线程直到deadline时间（从1970年到现在时间的毫秒数）
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
       // LockSupport.unpark(Thread.currentThread());//唤醒线程
    }
}
