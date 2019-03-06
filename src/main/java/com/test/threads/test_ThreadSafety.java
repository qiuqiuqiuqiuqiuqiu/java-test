package com.test.threads;

public class test_ThreadSafety {
    public static void main(String[] args)throws Exception {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt,"t1");
        t1.start();
        Thread t2 = new Thread(pt,"t2");
        t2.start();
        System.out.println("main thread " + System.currentTimeMillis());
        t1.join();
        System.out.println("main thread " + System.currentTimeMillis());
        t2.join();
        System.out.println("main thread " + System.currentTimeMillis());
        System.out.println("Processing count="+pt.getCount());
    }
}
