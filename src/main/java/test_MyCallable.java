
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class test_MyCallable implements Callable {

    @Override
    public String call() throws Exception{
        Thread.sleep(10000);
        return Thread.currentThread().getName();
    }

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<String>> list = new ArrayList<Future<String>>();

        Callable<String> callable = new test_MyCallable();

        for(int i=0;i<100;i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }

        for(Future<String> fut:list){
            try{
                System.out.println(new Date()+"::"+fut.get());
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
