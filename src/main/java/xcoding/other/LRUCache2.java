package xcoding.other;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache2 {

    public static void main(String[] args)
    {
        LRUCache2 ca = new LRUCache2(5);
        ca.put(1,1);
        ca.put(2,2);
        ca.put(3,3);
        ca.put(4,4);
        ca.put(5,5);
        ca.put(6,6);
        ca.put(2,2);
        ca.display();
    }

    Map<Integer, Integer> cache;
    int capacity;

    public LRUCache2(int capacity)
    {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if (!cache.containsKey(key))
            return -1;
        int val = cache.remove(key);
        cache.put(key, val);
        return val;
    }

    public void put(int key, int val)
    {
        if (cache.size() == capacity) {
            int firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
        cache.put(key, val);
    }

    public void display()
    {
        LinkedList<Integer> list = new LinkedList<>(cache.keySet());
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext())
            System.out.print(itr.next() + " ");
    }
}
