package datastructures.stack;

public class StackArrayTest<T> {

    public static void main(String[] args) {
        StackArrayTest<Integer> st= new StackArrayTest<Integer>(5);
        st.push(10);
        st.push(12);
        st.push(13);
        st.push(14);
        st.push(15);
        st.push(16);
        while(!st.isEmplty()){
            System.out.println(st.pop());
        }
        st.pop();
    }


    Object[] arrayStack;
    int size;
    int top;

    public StackArrayTest(int size) {
        this.size = size;
        arrayStack = new Object[this.size];
        top = -1;
    }

    public void push(Object newItem) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        top = top + 1;
        arrayStack[top] = newItem;
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


}