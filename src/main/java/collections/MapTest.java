package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> hm = new LinkedHashMap<Integer, String>();//HashMap,LinkedHashMap
        hm.put(1, "Amit");
        hm.put(2, "Vijay");
        hm.put(3, "Rahul");
        System.out.println(hm.get(2));
        hm.put(2, "Vijay2");
        System.out.println(hm.get(2));
        System.out.println("-------");
        hm.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
