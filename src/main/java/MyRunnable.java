public class MyRunnable implements Runnable {

    @Override
    public void run(){
        System.out.println("MyRunnable - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyRunnable - END "+Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }
}
