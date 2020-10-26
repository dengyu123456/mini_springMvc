package com.dy.threadDemo.threadDemo0616;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnSafe {
    static Unsafe unsafe = null;

    static long stateOffset = 0;

    private volatile long state = 0;

    //ABA问题，加时间戳解决
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //获取该变量
            unsafe = (Unsafe) field.get(null);
            //获取state TestUnSafe 的偏移量
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        TestUnSafe test = new TestUnSafe();
        Boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        int andSetInt = unsafe.getAndSetInt(test, stateOffset, 2);
        int andAddInt = unsafe.getAndAddInt(test, stateOffset, 1);

        System.out.println(andSetInt);
        System.out.println(andAddInt+""+test.state);
        System.out.println(sucess);
    }
}
