package functionalInterfaces;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * In this example main method calls retrieveExchangeRate which asynchronously
 * replies back via Consumer call back.
 */
public class FunctionalInterfaceConsumerExample {

    public static void main(String[] args) {
        retrieveExchangeRate(Currency.getInstance("USD"), (rate) -> System.out.println(rate));
    }

    public static void retrieveExchangeRate(Currency currency, Consumer<BigDecimal> rateConsumer) {
        System.out.println("Retrieving rate for currency " + currency);
        //just a test , no real exchange rate service call made.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> rateConsumer.accept(new BigDecimal(Math.round(Math.random() * 100))));
        executorService.shutdown();
    }
}