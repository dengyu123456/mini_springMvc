package com.dy.threadDemo.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);
    CountTask countTask = new CountTask();

    public static void main(String[] args) {

        try {
            c.await();
            c.reset();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void aVoid() {
        countTask.aVoid();
    }
}
