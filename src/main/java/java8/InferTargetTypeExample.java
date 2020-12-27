package java8;

public class InferTargetTypeExample {

    public static void main(String[] args) {
        twice(new Amount<>());//In Java 8 we don't need specific target data type.
    }

    public static void twice(Amount<Integer> amount) {
        //todo: apply twice logic
    }
}
class Amount<T> {
}