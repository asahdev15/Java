package datastructures.stacks;

public class StackLinkedListTest<T> {

    public static void main(String[] args) {
        StackLinkedListTest<String> st = new StackLinkedListTest<String>();
        st.pop();
        st.push("Hussein");
        st.push("Jena");
        System.out.println(st.pop());
        System.out.println(st.pop());
    }

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    Node top;

    public void push(Object value) {
        Node newNode = new Node(value);
        if (top == null)
            top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
    }

    public T pop() {
        if (top == null) {
            System.out.println("stack is empty");
            return null;
        }
        T value = (T) top.value;
        top = top.next;
        return value;
    }


}
