package collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    public static void main(String[] args) {

        hashMapTest();

    }

    private static void hashMapTest(){
        System.out.println("\n-- hashMapTest -- \n");
        Map<String, String> map = new HashMap<>();
        map.put("D", "4");
        map.put("C", "3");
        map.put("A", "1");
        map.putIfAbsent("B", "2");
        map.put(null, "null");
        System.out.println(map);
        System.out.println("------------------");
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map.containsKey("C"));
        System.out.println(map.get("C"));
        System.out.println(map.getOrDefault("X", "NA"));
        System.out.println(map.remove("C"));

        System.out.println("------------------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }
        System.out.println("------------------");
        Iterator<String> it2 = map.keySet().iterator();
        while(it2.hasNext()){
            String k = it2.next();
            System.out.println(k + " " + map.get(k));
        }
        System.out.println("------------------");
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.clear();
        System.out.println(map);
    }

    // maintains insertion order
    private static void linkedHashMap(){
        System.out.println("\nlinkedHashMap");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("D", "4");
        map.put("C", "3");
        map.put("A", "1");
        map.put("B", "2");
        map.put(null, "null");
        System.out.println(map);
        Iterator<String> it2 = map.keySet().iterator();
        while(it2.hasNext()){
            String k = it2.next();
            System.out.println(k + " " + map.get(k));
        }
    }

    // maintains ConcurrentModificationException exception handling
    private static void concurrentHashMap(){
        System.out.println("\nconcurrentHashMap");

        // this throws ConcurrentModificationException
//        Map<String,String> myMap = new HashMap<>();

        // this NOT throws ConcurrentModificationException
        Map<String,String> myMap = new ConcurrentHashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("Map : "+myMap);
        Iterator<String> it = myMap.keySet().iterator();
        while(it.hasNext()){
            String key = it.next(); // this throws ConcurrentModificationException
            System.out.println(key);
            if(key.equals("3")) myMap.put(key+"new", "new3");
        }
        System.out.println("Map : "+myMap);

    }


    // Sorts the keys of map
    private static void treeMapTest(){
        System.out.println("\ntreeMapTest");
        Map<String, String> map = new TreeMap<>();
        map.put("D", "4");
        map.put("C", "3");
        map.put("A", "1");
        map.put("B", "2");
//        map.put(null, "null"); // throws NullPointerException
        System.out.println(map);
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String k = it.next();
            System.out.println(k + " " + map.get(k));
        }



        System.out.println("\ntree map for students with default comparable ordering - age");
        Map<Student, String> map2 = new TreeMap<>();
        map2.put(new Student("D", 4), "4");
        map2.put(new Student("C", 3), "3");
        map2.put(new Student("A", 1), "1");
        map2.put(new Student("B", 2), "2");
//        map.put(null, "null"); // throws NullPointerException
        System.out.println(map2);
        Iterator<Student> it2 = map2.keySet().iterator();
        while(it2.hasNext()){
            Student k = it2.next();
            System.out.println(k + " " + map2.get(k));
        }


        System.out.println("\ntree map for students with comparator ordering - name desc");
        Comparator<Student> nameComparator = new Comparator<Student>(){
            @Override
            public int compare(Student c1, Student c2) {
                return -c1.name.compareTo(c2.name);
            }
        };
        Map<Student, String> map3 = new TreeMap<>(nameComparator);
        map3.put(new Student("D", 4), "4");
        map3.put(new Student("C", 3), "3");
        map3.put(new Student("A", 1), "1");
        map3.put(new Student("B", 2), "2");
//        map.put(null, "null"); // throws NullPointerException
        System.out.println(map3);
        Iterator<Student> it3 = map3.keySet().iterator();
        while(it3.hasNext()){
            Student k = it3.next();
            System.out.println(k + " " + map3.get(k));
        }

    }

}
