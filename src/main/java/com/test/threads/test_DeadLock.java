package com.test.threads;

public class test_DeadLock {
    public static void main(String[] args) throws InterruptedException{
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new SynchronizedThread(obj1,obj2), "t1");
        Thread t2 = new Thread(new SynchronizedThread(obj2,obj3), "t2");
        Thread t3 = new Thread(new SynchronizedThread(obj3,obj1), "t3");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
    }
}
