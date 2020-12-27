package datastructures.stack;

import java.util.Arrays;

public class StackDynamicArrayTest<T> {
    public static void main(String[] args) {
        StackDynamicArrayTest<Integer> st = new StackDynamicArrayTest<Integer>(2);
        st.push(12);
        st.push(12);
        System.out.println("Size stack:" + st.getSize());
        st.push(12);
        System.out.println("Size stack:" + st.getSize());
    }

    Object[] arrayStack;
    int size;
    int top;

    public StackDynamicArrayTest(int size) {
        this.size = size;
        arrayStack = new Object[this.size];
        top = -1;
    }

    public void push(Object newItem) {
        ensureCapacity(top + 2);
        top = top + 1;
        arrayStack[top] = newItem;
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = getSize();
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            arrayStack = Arrays.copyOf(arrayStack, newCapacity);
        }
    }

    public Boolean isFull() {
        return (top == size - 1);
    }

    public T pop() {
        if (isEmplty()) {
            System.out.println("stack is empty");
            return null;
        }
        T item = (T) arrayStack[top];
        top = top - 1;
        return item;

    }

    public Boolean isEmplty() {
        return (top == -1);
    }

    public int getSize() {
        return arrayStack.length;
    }


}