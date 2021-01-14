package xdatastructures.set;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    public static void main(String[] args){
        MyHashMap mp = new MyHashMap();
        mp.put(1,1);
        mp.put(2,2);
        mp.put(2,1);
        System.out.println(mp.get(1));
        System.out.println(mp.get(2));
    }

    private List<Node>[] bucket;
    private int capacity;
    private double loadFactor;
    private int count = 0;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        capacity = 1000;
        loadFactor = 0.75;
        bucket = new LinkedList[capacity];
    }

    public void put(int key, int value) {
        Node n = getNode(key);
        if(n != null){
            n.v = value;
            return;
        }
        if (loadFactor * capacity == count) {
            count = 0;
            capacity *= 2; // double the capacity
            List<Node>[] oldBucket = bucket;
            bucket = new LinkedList[capacity];
            for (int i = 0; i < oldBucket.length; i++) {
                List<Node> list = oldBucket[i];
                if (list != null) {
                    for (Node entry : list)
                        this.put(entry.k, entry.v);
                }
            }
        }
        int hash = key % capacity;
        if (bucket[hash] == null)
            bucket[hash] = new LinkedList<>();
        bucket[hash].add(new Node(key, value));
        ++count;
    }
    
    public int get(int key) {
        Node n = getNode(key);
        if(n==null)
            return -1;
        return n.v;
    }

    private Node getNode(int key){
        int hash = key % capacity;
        List<Node> list = bucket[hash];
        if (list != null) {
            for (Node n : list)
                if (n.k == key)
                    return n;
        }
        return null;
    }

    public void remove(int key) {
        int hash = key % capacity;
        List<Node> list = bucket[hash];
        if (list != null) {
            Iterator<Node> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().k == key) {
                    iterator.remove();
                    --count;
                }
            }
        }
    }

    class Node {
        public int k;
        public int v;
        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
}

