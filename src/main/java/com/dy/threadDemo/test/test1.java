//package com.dy.threadDemo.test;
//
//import java.util.List;
//import java.util.concurrent.ThreadPoolExecutor;
//
//public class test1 extends CountTask {
//    public static void main(String[] args) {
//        int i = Runtime.getRuntime().availableProcessors();
//        System.out.println(i);
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor();
//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        //返回等待执行的任务列表
//        List<Runnable> runnables = threadPoolExecutor.shutdownNow();
//    }
//
//}
