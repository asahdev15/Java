package java8.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * This example demonstrate the use of Predicate. Sum method is isolated from predicate validity logic,
 * hence it be used multiple times with different predicate logic.
 */
public class FunctionalInterfacePredicateExample {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(5, 3, 7, 1, 9, 4, 13, 6);
        System.out.println("Sum of even numbers " + getSum(integers, (i) -> i % 2 == 0));
        System.out.println("Sum of numbers greater than 5, " + getSum(integers, (i) -> i > 5));
    }

    public static int getSum(List<Integer> integerList, Predicate<Integer> predicate) {
        int sum = 0;
        for (Integer integer : integerList) {
            if (integer == null || !predicate.test(integer)) {
                continue;
            }
            sum += integer;
        }
        return sum;
    }
}