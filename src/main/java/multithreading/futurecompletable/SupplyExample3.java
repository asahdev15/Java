package multithreading.futurecompletable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class SupplyExample3 {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> ThreadLocalRandom.current().nextInt(1, 10))
                         .thenAccept(System.out::println)
                         .join();
    }
}