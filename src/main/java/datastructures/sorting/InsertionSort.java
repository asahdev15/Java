package datastructures.sort;


import asahdev.utils.ArrayUtils;

public class InsertionSort {

    public static void main(String[] args){
//
        int[] input = {4, 3, 2, 1, 0, -1, -99};
        ArrayUtils.printArrays(input);
        insertionSort(input);
        ArrayUtils.printArrays(input);
    }



    static void insertionSort(int [] A) {
        for(int  i = 1 ; i<A.length;i++) {
            int  tmp=A[i], j=i;
            while ( j>0 && A[j-1]>tmp ) {
                A[j]=A[j-1];
                j--;
            }
            A[j] = tmp;
        }//end of for loop
    }//end of method

}
