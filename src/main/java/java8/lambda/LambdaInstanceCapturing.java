package java8.lambda;

import java.math.BigDecimal;
import java.util.function.Function;

public class LambdaInstanceCapturing implements Runnable {

    private BigDecimal bd = new BigDecimal(1);

    @Override
    public void run() {
        Function<BigDecimal, BigDecimal> func = (a) -> bd.multiply(a);

        for (int j = 0; j < 999999999; j++) {
            func.apply(new BigDecimal(j));
        }
    }
}