package multithreading.futurescheduled;

import java.util.concurrent.*;

public class RunnableScheduledFuturePeriodicExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        };

        ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();
        RunnableScheduledFuture<?> scheduleFuture =
                (RunnableScheduledFuture<?>) es.scheduleAtFixedRate(runnable,
                        2, 1, TimeUnit.SECONDS);
        System.out.println("remaining delay: " + scheduleFuture.getDelay(TimeUnit.MILLISECONDS));
        System.out.println("periodic: " + scheduleFuture.isPeriodic());
        TimeUnit.SECONDS.sleep(5);
        scheduleFuture.cancel(true);
        es.shutdown();
    }
}