package multithreading.future;

import java.util.concurrent.*;

public class FutureGetExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Long> futureResult = es.submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                //simulating long running task
                Thread.sleep(1000);
                System.out.println("returning");
                return ThreadLocalRandom.current().nextLong();
            }
        });
        System.out.println("callable submitted");
        //after doing other stuff
        System.out.println("waiting for result");
        Long result = futureResult.get();//blocks until the task finishes
        System.out.println(result);
        es.shutdown();
    }
}