package datastructures.queues;

public class MyQueue {
 
	private int size;
	private int queueArray[];
	private int front;
	private int back;
	private int numofItems;
 
	public MyQueue(int s) {
		size = s;
		queueArray = new int[size];
		front = 0;
		back = -1;
		numofItems = 0;
	}
 
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue(5);
    	System.out.println("You have successfully created a Queue!");

		System.out.println("---------------------");
		if(queue.isEmpty())
			System.out.println("Queue is empty.");
		else
			System.out.println("Queue is not empty.");
		System.out.println("---------------------");
		System.out.println("%n");
		System.out.println("---------------------");
		if(queue.isFull())
			System.out.println("Queue is full.");
		else
			System.out.println("Queue is not full.");
		System.out.println("---------------------");

		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(6);
		queue.enqueue(8);
		queue.enqueue(10);

		System.out.println(queue.dequeue() + " " + queue.dequeue());

		queue.enqueue(12);
		queue.enqueue(14);

		System.out.println("Queue:");
		while(!queue.isEmpty()){
			System.out.print(queue.dequeue()+" ");
		}

	}

	public int top(){ //returns the element at the front of the queue
		return queueArray[front];
	}

	public boolean isEmpty(){
		return numofItems==0; //returns true if the queue is empty
	}

	public boolean isFull(){
		return numofItems == size; //returns true if the queue is full
	}
	public int getSize(){
		return numofItems; //returns the number of items currently present in the queue
	}

	public void enqueue(int value) {
		if(isFull()){
			System.err.println("Your queue is full!");
			return;
		}
		if (back == size - 1) {
			back = -1;
		}
		queueArray[++back] = value;
		++numofItems;
	}

	public int dequeue() {
		if(isEmpty()){
			System.err.println("Your queue is empty!");
			return -1;
		}
		int tmp = queueArray[front++];
		if (front == size ) {
			front = 0;
		}
		numofItems--;
		return tmp;
	}





}