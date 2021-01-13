package xdatastructures.linkedlist;

public class LinkedListDoubleTest<T> {

    private static class NodeDouble {
        NodeDouble previous;
        Object value;
        NodeDouble next;

        public NodeDouble(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedListDoubleTest<String> ls= new 	LinkedListDoubleTest<String>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        System.out.println("before delete");
        ls.display();
        System.out.println("\nafter delete");
        ls.delete();
        ls.display();
    }


    NodeDouble head;

    public void add(Object value) {
        NodeDouble newNode = new NodeDouble(value);
        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void delete() {
        head = head.next;
        head.previous = null;
    }

    public void display() {
        NodeDouble n = head;
        while (n != null) {
            System.out.print("<-"+"[p-"+(T) n.value+"-n]" + "->");
            n = n.next;
        }
    }
}