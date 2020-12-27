package datastructures.queue;

public class QueueLinkedListTest<T> {

    private static class NodeDouble {
        NodeDouble previous;
        Object value;
        NodeDouble next;

        public NodeDouble(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        QueueLinkedListTest<String> q = new QueueLinkedListTest<String>();
        q.queue("Jena");
        q.queue("Laya");
        q.queue("Hussein");
        System.out.println(q.Dequeue());
        System.out.println(q.Dequeue());
        System.out.println(q.Dequeue());
        System.out.println(q.Dequeue());
    }


    NodeDouble rear;
    NodeDouble front;

    public QueueLinkedListTest() {
        rear = null;
        front = null;
    }

    public void queue(Object value) {
        NodeDouble newNode = new NodeDouble(value);
        if (rear == null || front == null) {
            rear = newNode;
            front = newNode;
        } else {
            newNode.next = null;
            newNode.previous = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T Dequeue() {
        if (rear == null || front == null) {
            System.out.println("queue is emplty");
            return null;
        }
        T value = (T) front.value;
        front = front.next;
        if (front != null)
            front.previous = null;
        return value;
    }

}