package java8.functionalInterfaces;

import java.util.Currency;
import java.util.Locale;
import java.util.function.Supplier;


/**
 * In this example we pass a Supplier instance via lambda expression to displayCurrencyCode method,
 * beside use of lambda this example also shows how we can separate concerns via Supplier pattern.
 * In real application, we want to keep displaying/renderer and retrieving currency code logic
 * separated.
 */
public class FunctionalInterfaceSupplierExample {

    public static void main (String[] args) {
        displayCurrencyCode(() -> Currency.getInstance(Locale.CHINA).getCurrencyCode());
    }

    public static void displayCurrencyCode (Supplier<String> currencyCodeSupplier) {
        System.out.println(currencyCodeSupplier.get());
    }
}