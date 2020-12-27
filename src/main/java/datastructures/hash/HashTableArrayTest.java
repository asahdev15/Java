package datastructures.hash;

public class HashTableArrayTest<T> {

    static private class Entry {
        int key;
        Object value;
        Entry next;

        public Entry() {
        }

        public Entry(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTableArrayTest<String> hm = new HashTableArrayTest<String>(10);
        hm.put(11, "hussein");
        hm.put(12, "jena");
        hm.put(13, "laya");
        System.out.println(hm.get(11));
    }


    Entry[] arrayHash;
    int size;

    public HashTableArrayTest(int size) {
        this.size = size;
        arrayHash = new Entry[size];
        for (int i = 0; i < size; i++)
            arrayHash[i] = new Entry();
    }

    int getHash(int key) {
        return key % size;
    }

    public void put(int key, Object value) {
        int hashIndex = getHash(key);
        Entry arrayHead = this.arrayHash[hashIndex];
        Entry newItem = new Entry(key, value);
        newItem.next = arrayHead.next;
        arrayHead.next = newItem;
    }

    public T get(int key) {
        T value = null;
        int hashIndex = getHash(key);
        Entry arrayValue = arrayHash[hashIndex];
        while (arrayValue != null) {
            if (arrayValue.key == key) {
                value = (T) arrayValue.value;
                break;
            }
            arrayValue = arrayValue.next;
        }
        return value;
    }
}