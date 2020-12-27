package datastructures.sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        Integer[] arr = {1, 50, 30, 10, 60, 80};
        System.out.println("Before Sort");
        Arrays.stream(arr).forEach(i->System.out.print(i + "\t"));
        sort(arr);
        System.out.println("\nAfter Sort");
        Arrays.stream(arr).forEach(i->System.out.print(i + "\t"));
    }

    static int total;

    static void sort(Comparable[] arr) {
        total = arr.length - 1;
        for (int i = total / 2; i >= 0; i--)
            heapify(arr, i);
        for (int i = total; i > 0; i--) {
            swap(arr, 0, i);
            total--;
            heapify(arr, 0);
        }
    }

    static void heapify(Comparable[] arr, int i) {
        int lft = 2*i;
        int rgt = (2*i) + 1;
        int grt = i;
        if (lft <= total && arr[lft].compareTo(arr[grt]) >= 0)
            grt = lft;
        if (rgt <= total && arr[rgt].compareTo(arr[grt]) >= 0)
            grt = rgt;
        if (grt != i) {
            swap(arr, i, grt);
            heapify(arr, grt);
        }
    }

    static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}