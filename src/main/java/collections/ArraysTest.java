package collections;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        singleArray();
    }

    private static void singleArray(){
        int[] a = new int[]{10,9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

//        int[][] arr = {{0,0,0},{0,1,1}};
//        System.out.println(Arrays.deepToString(arr));

    }



}
