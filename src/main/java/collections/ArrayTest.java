package collections;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.IntConsumer;

public class ArrayTest {

    public static void main(String[] args) {
        int [] intArray = {3,1,24,5,4,61,59,7,15,3,12,22};
        Arrays.parallelSort(intArray);
        System.out.println(Arrays.toString(intArray));

        System.out.println("--------");

        int [] intArray2 = {1,2,3,4,5};
        Arrays.parallelPrefix(intArray2, (left, right) -> left + right);
        System.out.println(Arrays.toString(intArray2));

        System.out.println("--------");

        int [] intArray3 = new int[3];
        Arrays.setAll(intArray3, index -> index*2);
        System.out.println(Arrays.toString(intArray3));

        System.out.println("--------");

        int[] ints = new int[100];
        Arrays.fill(ints, 10);
        int sum = Arrays.stream(ints)
                .map(i -> (int) (Math.random() * i))
                .sum();
        System.out.println(sum);

        System.out.println("--------");
        int[] ints2 = new int[100];
        Arrays.fill(ints2, 10);
        Spliterator.OfInt spliterator = Arrays.spliterator(ints2);
        spliterator.forEachRemaining((IntConsumer) System.out::println);

    }
}
