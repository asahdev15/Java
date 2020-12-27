package multithreading.future;

import java.util.concurrent.*;

public class FutureNoResultsExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<?> futureResult = es.submit(new Runnable() {
            @Override
            public void run() {
                //simulating long running task
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("callable submitted");
        //after doing other stuff
        System.out.println("getting result");
        Object o = futureResult.get();
        System.out.println(o);
        es.shutdown();
    }
}