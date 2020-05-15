package com.dy.threadDemo.test;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * 同步器是实现锁（也可以是任意同步组件）的关键，在锁的实现中聚合同步器，利用同步 器实现锁的语义。
 * 可以这样理解二者之间的关系：锁是面向使用者的，它定义了使用者与锁交 互的接口（比如可以允许两个线程并行访问），
 * 隐藏了实现细节；同步器面向的是锁的实现者， 它简化了锁的实现方式，
 * 屏蔽了同步状态管理、线程的排队、等待与唤醒等底层操作。锁和同 步器很好地隔离了使用者和实现者所需关注的领域。
 */
public class Mutex implements Lock {

    private final Sync sync = new Sync();

    //获取锁
    public void lock() {
        sync.acquire(1);
    }

    //尝试非阻塞的获取锁，调用该方法后立刻返回，如果能获取返回t，否则返回f
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    //释放锁
    public void unlock() {
        sync.release(1);
    }

    /**
     * 这个只能由lock创建也就是condition是依赖于lock对象，相当于wait/notify
     * <p>
     * Condition中有await、
     * newCondition
     *
     * @return
     */
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock lock = new ReentrantLock();
//        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
//        reentrantReadWriteLock.readLock();
//        reentrantReadWriteLock.writeLock();
//        Condition condition = lock.newCondition();
//        LockSupport.parkNanos(100l);


        /**
         * jdk
         */
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(UUID.randomUUID().toString());
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("","");
    }


}

class Sync extends AbstractQueuedSynchronizer {
    // 是否处于占用状态
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }

    // 当状态为0的时候获取锁
    @Override
    public boolean tryAcquire(int acquires) {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    // 释放锁，将状态设置为0
    protected boolean tryRelease(int releases) {
        if (getState() == 0) throw new IllegalMonitorStateException();
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    // 返回一个Condition，每个condition都包含了一个condition队列
    Condition newCondition() {
        return new ConditionObject();
    }
}

