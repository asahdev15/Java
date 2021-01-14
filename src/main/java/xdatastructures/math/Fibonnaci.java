package xdatastructures.math;



import java.util.HashMap;
import java.util.Map;

public class Fibonnaci {

    public static void main(String[] args){
        fibonnaci(20);
    }

    private static void fibonnaci(int n){
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i < n ; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
//        ArrayUtils.printArrays(fib);
    }

    private static Map<Integer, Integer> memo = new HashMap();

    public static int fib(int n){
        if(n<0){
            throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");

        }
        if(n==0 || n==1){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = fib(n-1)+fib(n-2);
        memo.put(n, result);
        return result;
    }

    public static int fibIterative(int n) {
        // edge cases:
        if (n < 0) {
            throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");
        } else if (n == 0 || n == 1) {
            return n;
        }
        // we'll be building the fibonacci series from the bottom up
        // so we'll need to track the previous 2 numbers at each step
        int prevPrev = 0;  // 0th fibonacci
        int prev = 1;      // 1st fibonacci
        int current = 0;   // Declare and initialize current
        for (int i = 1; i < n; i++) {
            // Iteration 1: current = 2nd fibonacci
            // Iteration 2: current = 3rd fibonacci
            // Iteration 3: current = 4th fibonacci
            // To get nth fibonacci ... do n-1 iterations.
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }
        return current;
    }

}
