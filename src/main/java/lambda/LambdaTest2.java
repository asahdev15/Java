package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LambdaTest2 {
    public static void main(String[] args) {

        collectionSorting();


//        LambdaTest LambdaTest = new LambdaTest();
//        LambdaTest.aTestMethod();
//        for (Method method : LambdaTest.class.getDeclaredMethods()) {
//            System.out.println(method);
//        }
    }

    static private void collectionSorting() {
        List<Integer> list = Arrays.asList(2, 1, 5, 4, 3);
        Collections.sort(list, new Comparator<Integer>() {
            //            List<Integer> list2 = list;
            @Override
            public int compare(Integer a, Integer b) {
//                System.out.println(list + " Comparing : " + a+"-"+b);
                return a.compareTo(b);
            }
        });
        System.out.println(list);
        System.out.println("----------------");
//        list = Arrays.asList(2, 1, 4, 3);
        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println(list);

    }

    public void aTestMethod() {
        Runnable runnable = () -> {
            System.out.println("this " + this);
            throw new RuntimeException();
        };
        System.out.println("class:  " + runnable.getClass() + ", object : " + this);
        runnable.run();
    }

    private static void lambdaFunction() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        int comparision = comparator.compare("a", "c");
        System.out.println(comparision);

        Comparator<String> comparatorLambda = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        int comparatorLambdaResult = comparatorLambda.compare("a", "c");
        System.out.println(comparatorLambdaResult);
    }


    private void executorTest() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "done";
            }
        });

        future = executorService.submit(() -> "done");
    }

}



