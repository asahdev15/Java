package functionalInterfaces;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * We modified ConsumerExample to isolate the logic of getting Currency instance
 * from currency code and displaying logic as well. Generally Functions are used
 * in  mapping/transforming from one type to another. We will see more
 * examples in java.util.stream tutorials on that.
 */

public class FunctionalInterfaceFunctionExample {

    public static void main(String[] args) {
        displayCurrencyCode(currency -> getCurrencyRateForCurrencyCode(currency));
    }

    private static void displayCurrencyCode(Function<String, BigDecimal> currencyRateFunction) {
        BigDecimal rate = currencyRateFunction.apply("USD");
        System.out.println("Currency rate for USD : " + rate);
    }

    private static BigDecimal getCurrencyRateForCurrencyCode(String currency) {
        System.out.println("Getting rate for the currency: " + currency);
        //just a test, in real situation, we might be getting the currency rate for the provided currency from a cache
        return new BigDecimal(Math.round(Math.random() * 100));
    }
}