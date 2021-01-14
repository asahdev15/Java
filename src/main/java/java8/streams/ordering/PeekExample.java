package java8.streams.ordering;

import java.util.stream.IntStream;

public class PeekExample {
    public static void main (String[] args) {
        IntStream.range(0, 5).parallel().peek(System.out::println).
                            count();
    }
}