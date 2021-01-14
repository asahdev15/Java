package java8.streams.reduce;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceExample1 {
    public static void main(String[] args) {
        int i = IntStream.range(1, 6)
                .reduce((a, b) -> a * b)
                .orElse(-1);
        System.out.println(i);

        System.out.println("--------");
        int i2 = IntStream.range(1, 6)
                .parallel()
                .reduce(1,
                        (a, b) -> a * b);
        System.out.println(i2);

        System.out.println("--------");
        int i3 = IntStream.empty()
                .parallel()
                .reduce(1,
                        (a, b) -> a * b);
        System.out.println(i3);

        System.out.println("--------");
        int i4 = Stream.of("2", "3", "4", "5")
                .parallel()
                .reduce(0,
                        new BiFunction<Integer, String, Integer>() {
                            @Override
                            public Integer apply(Integer integer, String s) {
                                return Integer.sum(integer, Integer.parseInt(s));
                            }
                        },
                        new BinaryOperator<Integer>() {
                            @Override
                            public Integer apply(Integer integer, Integer integer2) {
                                return Integer.sum(integer, integer2);
                            }
                        }
                );

        System.out.println(i4);

        System.out.println("--------");
        int i5 = IntStream.range(1, 6)
                .parallel()
                .reduce(10,
                        (a, b) -> a * b);

        System.out.println(i5);


    }
}