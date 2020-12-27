package datastructures.queues;

import datastructures.stacks.MyStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckReverse {

  public static void main(String args[]) {

    Queue<Integer> q = new LinkedList<>();

    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);

    q=reverseK(q,3);

    System.out.print("Queue: ");
    while(!q.isEmpty()) {
      System.out.print(q.remove() + " ");
    }

  }

  //1.Push first k elements in queue in a stack.
  //2.Pop Stack elements and enqueue them at the end of queue
  //3.Dequeue queue elements till "k" and append them at the end of queue   
  public static Queue<Integer> reverseK(Queue<Integer> queue, int k) {

    if (!queue.isEmpty()) {
      Stack<Integer> stack = new Stack<>();
      int count = 0;

      while (count < k) {
        stack.push(queue.remove());
        count++;
      }

      while (!stack.isEmpty()) {
        queue.add(stack.pop());
      }

      int size = queue.size();
      for (int i = 0; i < size - k; i++) {
        queue.add(queue.remove());
      }

    } //end of if
    return queue;
  }

}