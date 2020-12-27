package datastructures.linkedlist;

public class LinkedListSingleTest<T> {

    private static class Node {
        Object value;
        Node next;
        public Node(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedListSingleTest<String> ls= new LinkedListSingleTest<String>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        System.out.println("before delete");
        ls.display();
        System.out.println("after delete");
        ls.delete();
        ls.display();
    }


    Node head;

    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void delete() {
        head = head.next;
    }

    public void display() {
        Node n = head;
        while (n != null) {
            System.out.print((T) n.value + "->");
            n = n.next;
        }
    }


}
