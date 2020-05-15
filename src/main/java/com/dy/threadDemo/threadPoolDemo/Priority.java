package com.dy.threadDemo.threadPoolDemo;

public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    static class Job implements Runnable {
        private int priority;
        private long jobCount;

        @Override
        public void run() {

        }

    }
}
