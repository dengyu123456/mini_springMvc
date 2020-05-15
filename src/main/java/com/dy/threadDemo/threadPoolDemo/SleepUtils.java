package com.dy.threadDemo.threadPoolDemo;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
