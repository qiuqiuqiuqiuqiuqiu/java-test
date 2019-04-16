package com.test.threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class test_MyCallable{

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<String>> list = new ArrayList<Future<String>>();

        Callable<String> callable = new MyCallable(1000);

        for(int i=0;i<100;i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }

        for(Future<String> fut:list){
            try{
                System.out.println(new Date()+"::"+fut.get());
            } catch (InterruptedException e){
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
