import java.util.concurrent.Callable;

public class MyCallable2 implements Callable<String> {

    private long waitTime;

    public MyCallable2(int timeInMillis){
        this.waitTime=timeInMillis;
    }

    @Override
    public String call() throws Exception{
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }
}
