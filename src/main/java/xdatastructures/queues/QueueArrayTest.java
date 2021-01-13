package xdatastructures.queue;

public class QueueArrayTest<T> {

    public static void main(String[] args){
        QueueArrayTest<Integer> q= new QueueArrayTest<Integer>(5);
        q.Queue(5);
        q.Queue(2);
        q.Queue(3);
        q.Queue(6);
        q.Queue(8);
        System.out.println("Dequeu:"+ q.DeQueue());
        System.out.println("Dequeu:"+ q.DeQueue());
    }


    Object[] arrayQueue;
    int rear;
    int front;
    int size;

    public QueueArrayTest(int size) {
        this.size = size;
        arrayQueue = new Object[this.size];
        front = -1;
        rear = -1;
    }

    public Boolean isFull() {
        return (rear == size - 1);
    }

    public Boolean isEmplty() {
        return (front == -1 || front > rear);
    }

    public void Queue(Object newItem) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        rear = rear + 1;
        arrayQueue[rear] = newItem;
        if (front == -1)
            front = 0;
    }

    public T DeQueue() {
        if (isEmplty()) {
            System.out.println("queue is empty");
            return null;
        }
        T ObjectOut = (T) arrayQueue[front];
        front = front + 1;
        return ObjectOut;
    }
}