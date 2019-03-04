import java.util.concurrent.*;

public class test_FutureTask {

    public static void main(String[] args){
        MyCallable2 callable1 = new MyCallable2(1000);
        MyCallable2 callable2 = new MyCallable2(2000);

        FutureTask<String> futureTask1 = new FutureTask<>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTask1);
        executor.execute(futureTask2);

        while(true){
            try{
                if(futureTask1.isDone() && futureTask2.isDone()){
                    System.out.println("Done");
                    executor.shutdown();
                    return;
                }

                if(!futureTask1.isDone()){
                    System.out.println("FutureTask1 output="+futureTask1.get());
                }

                System.out.println("Waiting for FutureTask2 to complete");
                String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                if(s!=null){
                    System.out.println("FutureTask2 output="+s);
                }
            }catch (InterruptedException| ExecutionException e){
                e.printStackTrace();
            }catch (TimeoutException e){
                e.printStackTrace();
            }
        }
    }
}
