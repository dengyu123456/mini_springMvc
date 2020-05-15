package com.dy.threadDemo.threadPoolDemo;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        int[] value = new int[]{1, 2};
        //AtomicIntegerArray只会改变复制的，不会改变原有的
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);
        atomicIntegerArray.compareAndSet(0, 1, 44);
        System.out.println(value[0]);
        System.out.println(atomicIntegerArray.get(0));
    }
}
