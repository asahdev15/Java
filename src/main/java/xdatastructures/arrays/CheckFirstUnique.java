package xdatastructures.arrays;

import java.util.HashMap;
import java.util.Map;

class CheckFirstUnique
{
  public static int findFirstUnique(int[] arr) {
    
    Map<Integer, Integer> countElements = new HashMap<>();
    for(int i = 0; i < arr.length; i++) {
      countElements.put(arr[i], 0);
    }
    
    for(int i = 0; i < arr.length; i++) {
      countElements.put(arr[i], countElements.get(arr[i]) + 1);
    }
    
    for(int i = 0; i < arr.length; i++) {
      if(countElements.get(arr[i]) <= 1) {
        return arr[i];
      }
    }
    return - 1;
  }

  public static String arrayToString(int arr[]){
    if (arr.length > 0){
      String result = "";
      for(int i = 0; i < arr.length; i++) {
        result += arr[i] + " ";
      }
      return result;
    }
    else {
      return "Empty Array!";
    }
  }

  public static void  main(String args[]) {

    int[] arr = {2, 54, 7, 2, 6, 54};

    System.out.println("Array: " + arrayToString(arr));

    int unique = findFirstUnique(arr);
    System.out.print("First Unique in an Array: " + unique);

  }
}