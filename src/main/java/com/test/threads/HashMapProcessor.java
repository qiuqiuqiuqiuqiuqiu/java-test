package com.test.threads;

public class HashMapProcessor implements Runnable {

    private String[] strArr = null;
    private Object lock = new Object();
    public HashMapProcessor(String[] m){
        this.strArr = m;
    }

    public String[] getMap(){
        return strArr;
    }

    @Override
    public void run(){
        processArr(Thread.currentThread().getName());
    }

    private void processArr(String name){
        for(int i=0; i<strArr.length; i++){
            processSomething(i);
            addThreadName(i, name);
        }
    }

    private void addThreadName(int i, String name){
        synchronized (lock){
            strArr[i] = strArr[i] + ":" + name;
        }
    }

    private void processSomething(int index){
        try {
            Thread.sleep(index*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
