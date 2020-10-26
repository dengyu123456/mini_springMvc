package com.dy.threadDemo.threadDemo0616;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * 自定义先进先出锁
 */
public class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();
//    AbstractQueuedSynchronizer AQS=new AbstractQueuedSynchronizer();
    public void lock() {
        Thread currentThread = Thread.currentThread();
        waiters.add(currentThread);
        boolean wasInterrupt = false;
        while (currentThread != currentThread || locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (currentThread.interrupted()) {
                //忽略中断，记录中断
                wasInterrupt = true;
            }
        }
        waiters.remove();
        if (wasInterrupt) {
            //恢复中断
            currentThread.interrupt();
        }
    }

    public void unLock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }


    public static void main(String[] args) {
        //测试

    }
}
