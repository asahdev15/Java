package xdatastructures.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointerProbs {
    public static void main(String[] args) {
        sortInplaceMain(args);
    }


    public static void sortInplaceMain(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        sortInplace(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        sortInplace(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    public static void sortInplace(int[] arr) {
        // all elements < low are 0 and all elements > high are 2
        // all elements from >= low < i are 1
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high;) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                // increment 'i' and 'low'
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // the case for arr[i] == 2
                swap(arr, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }





    //----------------------------------------------------------------

    public static void searchTripletsMain(String[] args) {
        System.out.println(searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
//        System.out.println(searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            // comparing the sum of two numbers to the 'targetSum' can cause integer overflow
            // so, we will try to find a target difference instead
            int targetDiff = targetSum - arr[left];
            if (targetDiff == arr[right]) { // found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--; // skip same element to avoid duplicate triplets
            } else if (targetDiff > arr[right])
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
    }

    //-------------------------------------------------------------------------------------

    public static void SortedArraySquares(String[] args) {

        int[] result = makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }



    //-------------------------------------------------------------------------------------

    public static void removeDuplicateElementsMain(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(removeDuplicateElements(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(removeDuplicateElements(arr));
    }

    private static int removeDuplicateElements(int[] items){
        int dupInd = 1; // index of the next non-duplicate element
        for(int i = 1 ; i < items.length ; i++){
            if(items[i] != items[dupInd-1]){
                items[dupInd] = items[i];
                dupInd++;
            }
        }
        return dupInd;
    }

    //-------------------------------------------------------------------------------------

    public static void pairWithTargetSum(String[] args) {
        int[] result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
    public static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // comparing the sum of two numbers to the 'targetSum' can cause integer overflow
            // so, we will try to find a target difference instead
            int targetDiff = targetSum - arr[left];
            if (targetDiff == arr[right])
                return new int[] { left, right }; // found the pair

            if (targetDiff > arr[right])
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[] { -1, -1 };
    }
}
