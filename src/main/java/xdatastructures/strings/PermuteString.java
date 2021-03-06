package xdatastructures.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class PermuteString{
  public static List<String> result = new ArrayList<String>();


  public static void main(String[] args) {
    String input = "abcd";
    System.out.println("All permutations of " + input);
    long start = System.currentTimeMillis();
    List<String> result = permuteString(input);
    System.out.println("Time Taken : (ms) " + (System.currentTimeMillis() - start));
    System.out.println(Arrays.toString(result.toArray()));


    List<String> result2 = new ArrayList<>();
    start = System.currentTimeMillis();
    result2.addAll(allPerms(input, new ArrayList<>()));
    System.out.println("Time Taken : (ms) " + (System.currentTimeMillis() - start));
    System.out.println(Arrays.toString(result2.toArray()));


    List<String> result3 = new ArrayList<>();
    start = System.currentTimeMillis();
    result3.addAll(findPermute(new String(), input));
    System.out.println("Time Taken : (ms) " + (System.currentTimeMillis() - start));
    System.out.println(Arrays.toString(result3.toArray()));
  }

  private static List<String> findPermute(String value, String input){
    List<String> result = new LinkedList<>();
    if(input.isEmpty()){
      result.add(value);
    }
    for(int i = 0; i<input.length(); i++){
      String newValue = value + input.charAt(i);
      String newInput = input.substring(0,i)+input.substring(i+1,input.length());
      result.addAll(findPermute(newValue, newInput));
    }
    return result;
  }

  static List<String> permuteString(String input) {
    permuteString(input.toCharArray(), 0);
    return result;
  }

  static void permuteString(char[] input, int currentIndex) {
    if(currentIndex == input.length - 1) {
      result.add(new String(input));
      return;
    }
    for(int i = currentIndex; i <= input.length - 1; i++) {
      swapChar(input,currentIndex,i);
      permuteString(input, currentIndex + 1);
      swapChar(input,currentIndex,i);
    }
  }

  static void swapChar(char[] input, int i, int j){
    char temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }



  private static List<String> allPerms(String str, List<Integer> idxs){
    List<String> result = new ArrayList();
    for(int i = 0 ; i < str.length(); i++) {
      if(!idxs.contains(i)){
        List<Integer> idxs2 = new ArrayList<>();
        idxs2.addAll(idxs);
        idxs2.add(i);
        List<String> others = allPerms(str, idxs2);
        for(String o : others){
          result.add(str.charAt(i) + o);
        }
        if(others.isEmpty()){
          result.add(str.charAt(i)+"");
        }
      }
    }
    return result;
  }



}