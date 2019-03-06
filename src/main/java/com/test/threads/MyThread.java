package com.test.threads;

public class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("MyThread - START "+Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
            doDBProcessing();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("MyThread - END "+Thread.currentThread().getName());
    }

    public void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }
}
