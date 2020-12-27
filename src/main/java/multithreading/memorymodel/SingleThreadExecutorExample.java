package multithreading.memorymodel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutorExample {

    public static void main (String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(new Runnable() {
            @Override
            public void run () {
                System.out.println("task running");
            }
        });

        executorService.shutdown();
    }
}