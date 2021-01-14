package java8.lambda;

import java.math.BigDecimal;
import java.util.function.Function;

public class LambdaLocalFinalCapturing implements Runnable {

    @Override
    public void run() {
        final BigDecimal bd = new BigDecimal(1);
        Function<BigDecimal, BigDecimal> func = (a) -> bd.multiply(a);

        for (int j = 0; j < 999999999; j++) {
            func.apply(new BigDecimal(j));
        }
    }
}