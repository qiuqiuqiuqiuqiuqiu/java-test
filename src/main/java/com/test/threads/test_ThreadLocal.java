package com.test.threads;

import java.text.SimpleDateFormat;
import java.util.Random;

public class test_ThreadLocal implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        test_ThreadLocal obj = new test_ThreadLocal();
        for (int i=0; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    private static final ThreadLocal<SimpleDateFormat> formatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    @Override
    public void run(){
        System.out.println("Thread Name = " + Thread.currentThread().getName() +
                " default Formatter = " + formatter.get().toPattern());

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name = " + Thread.currentThread().getName() +
                " formatter = " + formatter.get().toPattern());
    }
}
