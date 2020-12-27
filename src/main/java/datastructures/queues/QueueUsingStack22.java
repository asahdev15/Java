package datastructures.queues;

import java.util.Stack;

class QueueUsingStack22{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>(); 

    void enqueue(int data) {
      while(!stack1.isEmpty()) {
          stack2.push(stack1.pop());
      }

      stack1.push(data);

      while(!stack2.isEmpty()) {
          stack1.push(stack2.pop());
      }
    }

    boolean isEmpty() {
      return stack1.size() + stack2.size() == 0;
    }

    int dequeue() {
      if(isEmpty()) {
        return -1;
      }

      return stack1.pop();
    }
  }