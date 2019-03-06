package com.test.threads;

public class SynchronizedLock implements Runnable {

    private Resource resource;

    public SynchronizedLock(Resource r){
        this.resource = r;
    }

    @Override
    public void run(){
        synchronized (resource) {
            resource.doSomething();
        }
        resource.doLogging();
    }
}
