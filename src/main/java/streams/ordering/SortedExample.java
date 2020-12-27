package streams.ordering;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortedExample {

    public static void main (String[] args) {
        Set<Integer> list = new HashSet<>(Arrays.asList(2, 1, 3));
        Object[] objects = list.stream().sorted().toArray();
        System.out.println(Arrays.toString(objects));
    }
}