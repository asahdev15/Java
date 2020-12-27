package coding.other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRUCache {

    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 0;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;


    public LRUCache(int capacity1) {
        capacity = capacity1;
        cache = new HashMap<>(capacity);
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }



    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            node.value = value;
            add(node);
            return;
        }
        if(cache.size() == capacity){
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        add(node);
    }


    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        cache.remove(node.key);
    }

    private void add(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        cache.put(node.key, node);
    }

}