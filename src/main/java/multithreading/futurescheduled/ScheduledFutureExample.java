package multithreading.futurescheduled;

import java.util.concurrent.*;

public class ScheduledFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<Long> scheduleFuture = ses.schedule(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                System.out.println("returning result");
                return ThreadLocalRandom.current().nextLong();
            }
        }, 2, TimeUnit.SECONDS);
        //remaining delay
        long delay = scheduleFuture.getDelay(TimeUnit.SECONDS);
        System.out.println("task scheduled");
        System.out.println("remaining delay: " + delay);
        Long result = scheduleFuture.get();
        System.out.println(result);
        ses.shutdown();

    }
}