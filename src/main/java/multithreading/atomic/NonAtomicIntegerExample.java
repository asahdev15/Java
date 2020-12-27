package multithreading.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NonAtomicIntegerExample {
    private static int num;

    public static void main(String[] args) throws InterruptedException {
        for (int k = 0; k < 10; k++) {
            num = 0;
            ExecutorService es = Executors.newFixedThreadPool(2);
            es.execute(() -> {
                for (int i = 0; i < 10000; i++) {
                    num++;
                }
            });
            es.execute(() -> {
                for (int i = 0; i < 10000; i++) {
                    num++;
                }
            });
            es.shutdown();
            es.awaitTermination(10, TimeUnit.MINUTES);
            System.out.println(num);
        }
    }
}