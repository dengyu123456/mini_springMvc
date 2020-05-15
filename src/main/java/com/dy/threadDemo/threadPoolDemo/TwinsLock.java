package com.dy.threadDemo.threadPoolDemo;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock {

    private static final class Sync extends AbstractQueuedSynchronizer {
        int count;

        public Sync(int count) {
            if (count <= 0) {
                throw new RuntimeException("线程数量不能小于0");
            }
            setState(count);
        }

        //获取锁
        @Override
        public int tryAcquireShared(int reduceCount) {
            while (true) {
                int state = getState();
                int newCount = state - reduceCount;
                if (newCount < 0 || compareAndSetState(state, newCount)) {
                    return newCount;
                }
            }

        }

        //释放锁
        @Override
        public boolean tryReleaseShared(int returnCount) {
            while (true) {
                int state = getState();
                int newCount = state + returnCount;
                if (compareAndSetState(state, newCount)) {
                    return true;
                }
            }
        }
    }

    private static final Sync sync = new Sync(2);

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
