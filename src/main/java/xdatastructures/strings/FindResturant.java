package xdatastructures.strings;

import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindResturant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> items = new LinkedList<>();
        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < list2.length; i++){
            mp.put(list2[i], i);
        }
        for(int i = 0; i < list1.length && i<=min; i++){
            String s = list1[i];
            if(!mp.containsKey(s))
                continue;
            int sum = mp.get(s) + i;
            if(sum < min){
                items.clear();
                items.add(s);
                min = sum;
            }else if(sum == min){
                items.add(s);
            }
        }
        return items.toArray(new String[items.size()]);
    }
}
