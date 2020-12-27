package datastructures.queues;// Java orogram to demonstrate working of Queue
// interface in Java 
import java.util.LinkedList; 
import java.util.Queue; 

public class QueueExample {

	public static void main(String[] args){

		// FIFO -  First In First Out
		// (Remove from here) < < < < < ( Add in end )
		Queue<Integer> q = new LinkedList<>();

		q.add(1); q.add(2); q.add(3); q.add(4); q.add(5);

		System.out.println("Elements size => " + q.size());
		System.out.println("Elements => " + q);
		System.out.println("View first element => " + q.peek());
		System.out.println("Removed first element => " + q.remove());
		System.out.println("Elements => " + q);
	}

} 
