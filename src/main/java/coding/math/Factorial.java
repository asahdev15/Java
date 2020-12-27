package coding.math;

public class Factorial {

    public static int factorial(int n) {
        if(n<0){
            return 0;
        }else if(n==1 || n==0){
            return 1;
        }
        return n * factorial(n-1);
    }


}
