package programs;

public class FibonnaciSeries {

    public static void main(String[] args) {
        System.out.println(getFibonacciSeries(10));
    }

    private static String getFibonacciSeries(int count) {
        int n1 = 0;
        int n2 = 1;
        int sum = 0;

        if (count == 0 || count == 1) {
            return "";
        }
        if (count == 1) {
            return String.valueOf(n1);
        }
        if (count == 2) {
            return String.valueOf(n1) + " " + String.valueOf(n2);
        }
        int loop = 3;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(n1) + " " + String.valueOf(n2));
        while (loop <= count) {
            sum = n1 + n2;
            sb.append(" " + sum);
            n1 = n2;
            n2 = sum;
            loop++;
        }
        return sb.toString();
    }

}
