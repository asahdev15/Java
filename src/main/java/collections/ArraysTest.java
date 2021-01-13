package collections;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        singleArray();
    }

    private static void singleArray(){
        int[] a = new int[10];
        System.out.println(Arrays.toString(a));

        int[][] arr = {{0,0,0},{0,1,1}};
        System.out.println(Arrays.deepToString(arr));

    }



}
