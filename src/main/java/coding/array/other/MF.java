package coding.array.other;

import java.util.HashMap;
import java.util.Map;

public class MF {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.

        int[] array1 = {1, 3, 1, 3, 2, 1};
        System.out.println(mostFreqent(array1));
        
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        System.out.println(mostFreqent(array2));

        // mostFrequent(array3) should return null.
        int[] array3 = {};
        System.out.println(mostFreqent(array3));

        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        System.out.println(mostFreqent(array4));

        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};
        System.out.println(mostFreqent(array5));
    }

    public static Integer mostFreqent(int[] givenArray) {
        if(givenArray.length == 0)
          return null;
        if(givenArray.length == 1)
          return givenArray[0];
    
    
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for(int i : givenArray)
        {
          if(counter.containsKey(i))
          {
            counter.put(i, counter.get(i)+1);
          }else{
            counter.put(i, 1);
          }
        }
        Integer maxItem = 0;
        Integer maxValue = 0;
        
        for(Map.Entry<Integer, Integer> entry : counter.entrySet())
        {
          if(entry.getValue() > maxValue)
          {
                maxItem = entry.getKey();
              maxValue = entry.getValue();
          }
        }
        return maxItem;
  }
}
