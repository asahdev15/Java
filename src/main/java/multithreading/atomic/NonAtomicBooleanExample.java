package multithreading.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NonAtomicBooleanExample {
    private static boolean init;

    public static void init() {
        if (!init) {
            System.out.println("initializing");
            //initialize some expensive stuff
            init = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int c = 10;
        ExecutorService es = Executors.newFixedThreadPool(c);
        for (int i = 0; i < c; i++) {
            es.execute(NonAtomicBooleanExample::init);
        }
        es.shutdown();
        es.awaitTermination(10, TimeUnit.MINUTES);
    }
}