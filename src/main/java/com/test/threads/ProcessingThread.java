package com.test.threads;

public class ProcessingThread implements Runnable{
    private int count = 0;

    @Override
    public void run(){
        synchronized(this) {
            for(int i=1; i<5; i++){
                processSomething(i);
                count++;
            }
        }
    }

    public int getCount(){
        return this.count;
    }

    private void processSomething(int i){
        try{
            Thread.sleep(i*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
