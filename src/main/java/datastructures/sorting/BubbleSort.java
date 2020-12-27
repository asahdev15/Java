package datastructures.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 50, 30, 10, 60, 80};
        System.out.println("Before Sort");
        Arrays.stream(arr).forEach(i->System.out.print(i + "\t"));
        bubbleSort(arr);
        System.out.println("\nAfter Sort");
        Arrays.stream(arr).forEach(i->System.out.print(i + "\t"));
    }

    static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) //run from first cell to last cell
            for (int j = 0; j < n - i - 1; j++) //run from first cell to "last cell - iteration"
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }//end of method

}
