package lambda;

import java.util.LinkedHashMap;
import java.util.Map;

public class LambdaCapturingTest {
    private static Map<String, Long> map = new LinkedHashMap<>();

    public static void main(String[] args) {

        final int totalRuns = 5;
        for (int i = 0; i < totalRuns; i++) {
            runTest("Lambda local final capturing", new LambdaLocalFinalCapturing());
            runTest("Lambda local effectively final capturing", new LambdaLocalEffectivelyFinalCapturing());
            runTest("Lambda instance capturing", new LambdaInstanceCapturing());
            runTest("Lambda non capturing", new LambdaNonCapturing());
        }
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.printf("%s  time: %d %n", entry.getKey(), entry.getValue() / totalRuns);
        }
    }

    private static void runTest(String name, Runnable runnable) {
        long time = System.currentTimeMillis();
        runnable.run();
        if (!map.containsKey(name)) {
            map.put(name, 0L);
        }
        map.put(name, map.get(name) + (System.currentTimeMillis() - time));
    }
}