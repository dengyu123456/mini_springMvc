package com.dy.threadDemo.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomincDemo {

    static class User {
        private String name;
        private int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.addAndGet(2);
        boolean b = atomicInteger.compareAndSet(4, 4);
        System.out.println(b);
        int i = atomicInteger.get();
        atomicInteger.getAndIncrement();
        System.out.println(i);
        Integer j = 1;
        Thread thread1 = new Thread("thread1") {
            @Override
            public void run() {
                super.run();
                ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
                int m = 1;
                threadLocal.set(m);
                atomicInteger.addAndGet(6);
            }
        };
        new Thread("thread2") {
            @Override
            public void run() {
                super.run();

            }
        }.start();
        thread1.start();
        try {
            thread1.join();
            System.out.println(atomicInteger.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        AtomicReference<User> atomicReference=new AtomicReference<>();
//        atomicReference.compareAndSet()
    }
}
