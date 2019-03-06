package com.test.threads;

public class test_DaemonThread {
    public static void main(String[] args) throws InterruptedException{
        Thread dt = new Thread(new DaemonThread(), "dt");
        dt.setDaemon(true);
        dt.start();
        Thread.sleep(30000);
        System.out.println("Finishing program");
    }
}
