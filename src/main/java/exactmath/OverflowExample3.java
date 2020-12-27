package exactmath;

import java.math.BigInteger;

public class OverflowExample3 {

    public static void main(String[] args) {
        int i = 2000000000;
        int j = 1000000000;

        try {
            int out = Math.addExact(i, j);
            System.out.println(out);
        }catch (ArithmeticException e){
            BigInteger b1 = BigInteger.valueOf(i);
            BigInteger b2 = BigInteger.valueOf(j);
            BigInteger output = b1.add(b2);
            System.out.println(output);
        }
    }
}