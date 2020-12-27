package lambda;

import java.math.BigDecimal;
import java.util.function.Function;

public class LambdaNonCapturing implements Runnable {

    @Override
    public void run() {
        Function<BigDecimal, BigDecimal> func = (a) -> a.multiply(BigDecimal.TEN);

        for (int j = 0; j < 999999999; j++) {
            func.apply(new BigDecimal(j));
        }
    }
}