package java8.streams.collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorExample {
    public static void main(String[] args) {

        System.out.println("------------");
        List<String> list = Arrays.asList("Mike", "Nicki", "John");
        String s2 = list.stream().collect(StringBuilder::new,
                (sb, s1) -> sb.append(" ").append(s1),
                (sb1, sb2) -> sb1.append(sb2.toString())).toString();
        System.out.println(s2);

        System.out.println("------------");
        List<String> list2 = Arrays.asList("Mike", "Nicki", "John");
        String s3 = list2.stream().reduce("", (s11, s22) -> s11 + " " + s22);
        System.out.println(s3);

        System.out.println("------------");
        IntStream stream = IntStream.range(1, 100);
        List<Integer> list3 = stream.parallel()
                .filter(i -> i % 10 == 0)
                .collect(ArrayList::new, ArrayList::add
                        , ArrayList::addAll);
        System.out.println(list3);

        System.out.println("------------");
        String s = Stream.of("Mike", "Nicki", "John").
                collect(new MyCollector());
        System.out.println(s);


    }

    private static class MyCollector implements
            Collector<String, StringBuilder, String> {

        @Override
        public Supplier<StringBuilder> supplier() {
            return StringBuilder::new;
        }

        @Override
        public BiConsumer<StringBuilder, String> accumulator() {
            return (sb, s) -> sb.append(" ").append(s);
        }

        @Override
        public BinaryOperator<StringBuilder> combiner() {
            return (sb1, sb2) -> sb1.append(sb2);
        }

        @Override
        public Function<StringBuilder, String> finisher() {
            return stringBuilder -> stringBuilder.toString();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }
}