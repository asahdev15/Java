package lambda;

import java.lang.reflect.Method;

public class LambdaTest {

    public void aTestMethod() {
        Runnable runnable = () -> {
            System.out.println("this " + this);
            throw new RuntimeException();
        };
        System.out.println("class:  " + runnable.getClass());
        runnable.run();
    }

    public static void main(String[] args) {
        for (Method method : LambdaTest.class.getDeclaredMethods()) {
            System.out.println(method);
        }
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.aTestMethod();
    }
 }