package exactmath;

public class OverflowExample1 {

    public static void main(String[] args) {
        int i = 2000000000;
        int j = 1000000000;

        int out = i + j;
        System.out.println(out);
    }
}