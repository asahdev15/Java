package java8.exactmath;

public class OverflowExample2 {

    public static void main(String[] args) {
        int i = 2000000000;
        int j = 1000000000;

        int out = Math.addExact(i, j);
        System.out.println(out);
    }
}