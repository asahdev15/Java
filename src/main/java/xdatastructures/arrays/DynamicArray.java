package xdatastructures.arrays;

import java.util.Arrays;

public class DynamicArray<T> {

    public static void main(String[] args) {
        DynamicArray<Integer> da= new DynamicArray<Integer>();
        da.put(11);
        System.out.println("Size:"+ da.getSize());
        da.put(12);
        System.out.println("Size:"+ da.getSize());
        da.put(13);
        System.out.println("Size:"+ da.getSize());
        da.put(14);
        System.out.println("Size:"+ da.getSize());
        da.put(15);
        System.out.println("Size:"+ da.getSize());
        System.out.println("Element saved is:");
        for (int i=0;i<da.getSize();i++)
            System.out.println(da.get(i));
    }


    Object[] data;
    int size;

    public DynamicArray() {
        size = 0;
        data = new Object[1];
    }

    public int getSize() {
        return data.length;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public void put(Object element) {
        ensureCapacity(size + 1);
        data[size++] = element;
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = getSize();
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

}