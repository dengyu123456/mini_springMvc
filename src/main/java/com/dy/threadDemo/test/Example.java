package com.dy.threadDemo.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Example {
    String str = new String("tarena");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String args[]) {
//        Example ex = new Example();
//        ex.change(ex.str, ex.ch);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);

    }

    public void change(String str, char ch[]) {
        //引用类型变量，传递的是地址，属于引用传递。     
        str = new String("test ok");
        ch[0] = 'g';
    }
}

