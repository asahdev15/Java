package xdatastructures.stacks;

import java.util.ArrayDeque;
import java.util.Queue;

class StackUsingQueue2{

    Queue<Integer> queue1 = new ArrayDeque<Integer>();
    Queue<Integer> queue2 = new ArrayDeque<Integer>();

    void push(int data) {
      if(queue1.isEmpty()) {
        queue1.add(data);
      }
      else {
        queue2.add(data);
        while(!queue1.isEmpty()) {
          queue2.add(queue1.remove());
        }
        swap_queues();
      }
    }  

    boolean isEmpty() {
      return queue1.size() + queue2.size() == 0;
    }

    int pop() {
      if(isEmpty()) {
        return -1;
      }
      return queue1.remove();
    }

    void swap_queues() {
      Queue<Integer> queue3 = queue1;
      queue1 = queue2;
      queue2 = queue3;
    }
  }