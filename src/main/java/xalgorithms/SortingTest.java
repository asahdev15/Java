package xalgorithms;

import java.util.Arrays;
import java.util.Random;

public class SortingTest {

    public static void main( String args[] ) {
        Integer[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        Integer[] input = getRandomArray();
//
//        input = getRandomArray();
//        long start = System.currentTimeMillis();
//            bubbleSort(input);
//        long end = System.currentTimeMillis();
//        System.out.println("Bubble Sort Time taken = " + (end - start));
//
//        input = getRandomArray();
//        long start6 = System.currentTimeMillis();
//        selectionSort(input);
//        long end6 = System.currentTimeMillis();
//        System.out.println("Selection Sort Time taken = " + (end6 - start6));
//
//        input = getRandomArray();
        long start3 = System.currentTimeMillis();
        insertionSort(input);
        long end3 = System.currentTimeMillis();
        System.out.println("Insertion Sort Time taken = " + (end3 - start3));

//        input = getRandomArray();
//        long start2 = System.currentTimeMillis();
//            mergeSort(input, 0, input.length-1);
//        long end2 = System.currentTimeMillis();
//        System.out.println("Merge Sort Time taken = " + (end2 - start2));
//
//        input = getRandomArray();
//        long start4 = System.currentTimeMillis();
//        heapSort(input);
//        long end4 = System.currentTimeMillis();
//        System.out.println("Heap Sort Time taken = " + (end4 - start4));
//
//        input = getRandomArray();
//        long start5 = System.currentTimeMillis();
//        quickSort(input, 0, input.length - 1);
//        long end5 = System.currentTimeMillis();
//        System.out.println("Quick Sort Time taken = " + (end5 - start5));

        System.out.println(Arrays.toString(input));
    }

    static Integer[] getRandomArray(){
        Random random = new Random(System.currentTimeMillis());
        int SIZE = 10000;
        Integer[] input = new Integer[SIZE];
        for (int i = 0; i < 10000; i++) {
//            input[i] = random.nextInt(10000);
            input[i] = SIZE;
            SIZE--;
        }
        return input;
    }

    static void bubbleSort(Integer[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int tmp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = tmp;
                }
            }
        }
    }

    static void mergeSort(Integer[] Array, int left, int right) {
        if (right > left) {
            int m = (left + right) / 2;
            mergeSort(Array, left, m);
            mergeSort(Array, m + 1, right);
            merge(Array, left, m, right);
        }
    }//end of method

    static void merge(Integer[] A, int left, int middle, int right) {

        int [] leftTmpArray = new int[middle-left+2];  //Create tmp arrays
        int [] rightTmpArray = new int[right-middle+1];

        for(int i=0;i<=middle-left;i++) //Copy values from Array 'A' to these tmp arrays
            leftTmpArray[i]= A[left+i];

        for(int i=0;i<right-middle;i++)
            rightTmpArray[i]= A[middle+1+i];

        leftTmpArray[middle-left+1]= Integer.MAX_VALUE; //Merge values and insert into Array 'A'
        rightTmpArray[right-middle] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (leftTmpArray[i] < rightTmpArray[j]) {
                A[k] = leftTmpArray[i];
                i++;
            } else {
                A[k] = rightTmpArray[j];
                j++;
            }
        }

    }//end of method

    static void insertionSort(Integer [] A){
        for(int i = 1 ; i < A.length ; i++){
            int tmp = A[i];
            int j = i;
            while (j > 0 && A[j-1] > tmp){
                A[j] = A[j-1];
                j--;
            }
            A[j] = tmp;
        }//end of for loop
    }//end of method



    static int total;
    static void heapSort(Comparable[] arr) {
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


    static void quickSort(Integer[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high);

    }


    static void selectionSort(Integer[] a) {
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
