package coding.array.other;


import asahdev.utils.ArrayUtils;
import asahdev.utils.UtilsMaths;

class CheckRemoveEven {

    public static void main(String args[]) {

        int[] arr = new int[]{1, 2, 4, 5, 10, 6, 3};
        ArrayUtils.printArrays(arr);

        int[] newArr =  removeEven(arr); // calling removeEven
        ArrayUtils.printArrays(newArr);
    }

    public static int[] removeEven(int[] arr) {
        int oddElements = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!UtilsMaths.isNumberEven(arr[i]))
                oddElements++;
        }
        //Create result array with the size equal to the number of odd elements in arr
        int[] result = new int[oddElements];
        int result_index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!UtilsMaths.isNumberEven(arr[i]))
                result[result_index++] = arr[i];
        }
        return result;
    }



}
