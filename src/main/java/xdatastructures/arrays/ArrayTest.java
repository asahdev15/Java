package xdatastructures.arrays;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        oneDimensionalArray();
    }

    private static void oneDimensionalArray() {
        int[] name = new int[5];
        Arrays.stream(name).forEach(i->System.out.print(i+" "));
        System.out.println(name);
        for (int i=0; i < name.length ; i++){
            name[i]=i;
        }
        Arrays.stream(name).forEach(i->System.out.print(i+" "));
        System.out.println(name);
    }

    private static void twoDimensionalArray(){
        int[][] name = new int[3][3];
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                name[row][col]=row*col;
            }
        }
        Arrays.stream(name).forEach(ints -> {
            Arrays.stream(ints).forEach(i -> System.out.print(i+"\t"));
            System.out.println();
        });
    }
}
