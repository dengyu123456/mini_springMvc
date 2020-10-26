package com.dy.threadDemo.threadPoolDemo;

public class SynchonizedTest {

    public synchronized void test1() {
        for (int i = 0; i < 500; i++)
            System.out.println("test1 加了synchronized的普通方法.。。。。。。。" + Thread.currentThread().getName());
    }

    public synchronized void test01() {
        for (int i = 0; i < 500; i++)
            System.out.println("test01 加了synchronized的普通方法");
    }

    public void test2() {
        for (int i = 0; i < 500; i++)
            System.out.println("test2 不加synchronized的普通方法");
    }

    public static synchronized void test3() {
        for (int i = 0; i < 500; i++)
            System.out.println("test3 加了synchronized的静态方法 ");
    }

    public static synchronized void test4() {
        for (int i = 0; i < 500; i++)
            System.out.println("test4 加了synchronized的静态方法 ");
    }

    public void test5() {
        System.out.println("锁当前实例对象同步代码块执行开始");
        synchronized (this) {
            for (int i = 0; i < 500; i++)
                System.out.println("test5 当前对象实例锁");
        }
    }

    public static Integer i = 1;

    public void test6() {
        System.out.println("锁静态变量同步代码块开始执行");
        synchronized (i) {
            for (int i = 0; i < 500; i++)
                System.out.println("test6 锁静态变量" + Thread.currentThread().getName());
        }
    }

    public Integer j = 1;

    public void test7() {
        System.out.println("锁普通变量同步代码块开始执行");
        synchronized (j) {
            for (int i = 0; i < 500; i++)
                System.out.println("test6 锁普通变量");
        }
    }


    public static void t1() {
        //1、测试同步实例方法 test1 加了synchronized的普通方法 test2 不加synchronized的普通方法
        SynchonizedTest test1 = new SynchonizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test1();
                System.out.println();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test2();
            }
        }).start();
        //输出：test1和test2交替输出
        //结论：同一个对象中加了synchronized的普通方法并不影响不加的普通方法
        //test1和test2互不影响
    }

    public static void t2() {
        SynchonizedTest test1 = new SynchonizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test5();
                // test5 当前对象实例锁
            }
        }).start();
        //输出依次输出test1和test5
        //结论：锁当前对象和普通方法上锁 锁的对象都是当前实例
    }

    public static void t3() {
        SynchonizedTest test1 = new SynchonizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test01();
            }
        }).start();
        //输出：test1和test01依次输出
        //结论：对于两个不同的普通方法加了synchronized 锁的对象是当前实例
    }

    public static void t4() {
        SynchonizedTest test1 = new SynchonizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test7();
            }
        }).start();
        //输出test1和test6交替输出
        //结论：普通方法加锁锁的是当前对象 普通成员变量加锁锁的是成员变量synchronized修饰的和实例对象无关

    }

    public static void t5() {
        SynchonizedTest test1 = new SynchonizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test4();
            }
        }).start();
        //输出test1和test4交替输出
        //结论：静态变量加锁和同步方法加锁不会影响，两个是独立的
    }

    public static void t6() {
        SynchonizedTest test1 = new SynchonizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test6();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test4();
            }
        }).start();
        //输出：test4和test6交替输出
        //静态方法加锁和静态变量加锁两个互不影响，静态方法加锁锁的是Class对象，静态变量加锁锁的是synchronized修饰的变量
    }

    public static void t7() {
        SynchonizedTest test1 = new SynchonizedTest();
        SynchonizedTest test2 = new SynchonizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test6();
            }
        }, "test1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.test6();
            }
        }, "test2....").start();
        //输出：依次输出test1线程和test2线程
        //静态方法加锁锁的是Class对象，不同对象实例依然属于同一个Calss对象
    }

    public static void t8() {
        SynchonizedTest test1 = new SynchonizedTest();
        SynchonizedTest test2 = new SynchonizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.test1();
            }
        }, "test1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.test1();
            }
        }, "test2....").start();
        //输出：交替输出test1线程和test2线程
        //普通方法锁的是当前对象实例，当新创建两个对象实例时两个并不影响
    }

    public static void main(String[] args) {
        t4();
    }
}
