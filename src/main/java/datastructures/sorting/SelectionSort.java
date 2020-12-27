package datastructures.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1, 50, 30, 10, 60, 80};
        System.out.println("Before Sort");
        Arrays.stream(arr).forEach(i->System.out.print(i + "\t"));
        selectionSort(arr);
        System.out.println("\nAfter Sort");
        Arrays.stream(arr).forEach(i->System.out.print(i + "\t"));
    }


    static void selectionSort(int[] a) {
        for (int i = 0; i<a.length; i++) {
            int minimumIndex = i;
            for (int j=i+1; j<a.length; j++) {
                if (a[minimumIndex] > a[j]) //find which is the smallest element to right of 'j'
                    minimumIndex = j;
            }//end of inner loop
            if (minimumIndex != i) { // if j is not minimum index then swap
                int temp = a[i];
                a[i] = a[minimumIndex];
                a[minimumIndex] = temp;
            }
        }//end of outer loop
    }//end of method




}