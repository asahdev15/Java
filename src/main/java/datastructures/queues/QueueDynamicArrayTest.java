package datastructures.queue;

import java.util.Arrays;

public class QueueDynamicArrayTest<T> {

    public static void main(String[] args) {
        QueueDynamicArrayTest<Integer> q = new QueueDynamicArrayTest<Integer>(2);
        q.Queue(11);
        q.Queue(12);
        System.out.println("Size:" + q.getSize());
        q.Queue(12);
        System.out.println("Size:" + q.getSize());

        System.out.println("Dequeu:"+ q.DeQueue());
        System.out.println("Dequeu:"+ q.DeQueue());
        System.out.println("Dequeu:"+ q.DeQueue());
        System.out.println("Dequeu:"+ q.DeQueue());
    }

    Object[] arrayQueue;
    int rear;
    int front;
    int size;

    public QueueDynamicArrayTest(int size) {
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
        ensureCapacity(rear + 2);
        rear = rear + 1;
        arrayQueue[rear] = newItem;
        if (front == -1)
            front = 0;
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = getSize();
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            arrayQueue = Arrays.copyOf(arrayQueue, newCapacity);
        }
    }

    public int getSize() {
        return arrayQueue.length;
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