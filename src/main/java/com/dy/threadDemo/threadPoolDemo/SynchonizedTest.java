package com.dy.threadDemo.threadPoolDemo;

public class SynchonizedTest {

    public synchronized void test1() {
        System.out.println("test1 加了synchronized的普通方法");
    }

    public synchronized void test2() {
        System.out.println("test2 加了synchronized的普通方法");
    }

    public static synchronized void test3() {
        System.out.println("test3 加了synchronized的静态方法 ");
    }

    public static synchronized void test4() {
        System.out.println("test4 加了synchronized的静态方法 ");
    }

    public void test5() {
        System.out.println("锁当前实例对象同步代码块执行开始");
        synchronized (this) {
            System.out.println("test5 当前对象实例锁");
        }
    }

    public static Integer i = 1;

    public void test6() {
        System.out.println("锁静态变量同步代码块开始执行");
        synchronized (i) {
            System.out.println("test6 锁静态变量");
        }
    }

    public Integer j = 1;

    public void test7() {
        System.out.println("锁普通变量同步代码块开始执行");
        synchronized (j) {
            System.out.println("test6 锁普通变量");
        }
    }

    public static void main(String[] args) {

    }

}
