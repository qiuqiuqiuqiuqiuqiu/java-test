package com.test.threads;

public class HeavyWorkRunnable implements Runnable {

    @Override
    public void run(){
        System.out.println("HeavyWorkRunnable - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("HeavyWorkRunnable - END "+Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }
}
