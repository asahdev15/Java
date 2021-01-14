package xdatastructures.math;

import java.math.BigInteger;
import java.util.Scanner;

public class DecimalToBinay {

    private static Scanner sc;

    public static void main(String[] args) {


//        Integer.toBinaryString(dec);


        sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            runTest();
        }
    }

    static class Counts{
        int count0;
        int count1;
    }

    private static void runTest(){
        BigInteger n = sc.nextBigInteger();
//        String binaryVersion = convertDecimalToBinary(n);

        String binaryVersion = print2Binaryform(n);
        printSubStrings(binaryVersion);

    }

    private static BigInteger bigInteger2 = new BigInteger(""+2);

    private static String print2Binaryform(BigInteger number) {
        String result = "";
        BigInteger reminder2;
        if(number.compareTo(BigInteger.ZERO) == 0){
            result = "0";
        }else if(number.compareTo(BigInteger.ONE)<=0){
            result = "1";
        }else{
            reminder2 = number.mod(bigInteger2);
            BigInteger quotient = number.divide(bigInteger2);
            result = print2Binaryform(new BigInteger(""+quotient)) + reminder2;
        }
        return result;
    }

    private static void printSubStrings(String a){
        int count0Odd = 0;
        int count1Odd = 0;
//        System.out.println(a);
        for(int i = 0 ; i < a.length() ; i++){
//            System.out.println(i);
            for(int j = i ; j < a.length() ; j++){
                String sub = a.substring(i,j+1);
                Counts counts = count(sub);
                if(isOddNumber(counts.count0)){
                    count0Odd++ ;
                }
                if(isOddNumber(counts.count1)){
                    count1Odd++ ;
                }
//                System.out.println(sub + " - count0:" + counts.count0 + ", counts1:" + counts.count1);
            }
        }
        System.out.println(count0Odd + " " + count1Odd);
    }

    private static boolean isOddNumber(int n){
        return n % 2 > 0;
    }

    private static Counts count(String a){
        Counts counts = new Counts();
        for(int i = 0 ; i < a.length() ; i++){
            if(a.charAt(i)=='1'){
                counts.count1++;
            }else{
                counts.count0++;
            }
        }
        return counts;
    }

    private static String convertDecimalToBinary(long n){
        String x = "";
        long a = 0;
        while(n > 0)
        {
            a = n % 2;
            x = x + "" + a;
            n = n / 2;
        }
        if(n==0){
            x = "0";
        }
        return x;
    }


    // function to convert decimal to binary
    static void decToBinary(int n)
    {
        // array to store binary number
        int[] binaryNum = new int[1000];

        // counter for binary array
        int i = 0;
        while (n > 0)
        {
            // storing remainder in binary array
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }

        // printing binary array in reverse order
        for (int j = i - 1; j >= 0; j--)
            System.out.print(binaryNum[j]);
    }

}
