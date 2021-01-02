package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> hm = new LinkedHashMap<>();
        hm.put(1, "1");
        hm.put(2, "2");
        hm.put(3, "3");
        hm.put(4, "4");
        Iterator<Integer> it = hm.keySet().iterator();
        while(it.hasNext()){
            int k = it.next();
            System.out.println(k + " " + hm.get(k));
        }
        System.out.println("-------------------------");
        Map<Integer, String> hm2 = new HashMap<>();
        hm2.put(1, "1");
        hm2.put(2, "2");
        hm2.put(3, "3");
        hm2.put(4, "4");
        Iterator<Integer> it2 = hm2.keySet().iterator();
        while(it2.hasNext()){
            int k = it2.next();
            System.out.println(k + " " + hm2.get(k));
        }
    }
}
