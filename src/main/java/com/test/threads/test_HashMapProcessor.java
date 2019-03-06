package com.test.threads;

import java.util.Arrays;

public class test_HashMapProcessor {

    public static void main(String[] args) throws InterruptedException {
        String[] arr = {"1", "2", "3", "4", "5", "6"};
        HashMapProcessor hmp = new HashMapProcessor(arr);
        Thread t1 = new Thread(hmp, "t1");
        Thread t2 = new Thread(hmp, "t2");
        Thread t3 = new Thread(hmp, "t3");

        long start = System.currentTimeMillis();

        t1.start();t2.start();t3.start();

        t1.join();t2.join();t3.join();

        System.out.println("Time taken = " + (System.currentTimeMillis() - start));
        System.out.println(Arrays.asList(hmp.getMap()));
    }
}
