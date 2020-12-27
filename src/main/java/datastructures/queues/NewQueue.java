package datastructures.queues;

import datastructures.stacks.MyStack;

//We can use 2 stacks for this purpose,mainStack to store original values
//and tempStack which will help in enqueue operation.
//Main thing is to put first entered element at the top of mainStack
class NewQueue {

	//Inserts Element in the Queue
	public void enQueue(int value) {

		//Traverse elements from mainStack to tempStack
		//Push given value to mainStack
		//Traverse back the elements from tempStack to mainStack
		while (!mainStack.isEmpty()) {

			tempStack.push(mainStack.pop());
		}

		mainStack.push(value);

		while (!tempStack.isEmpty()) {

			mainStack.push(tempStack.pop());
		}
	} //end of enQueue
	//Removes Element From Queue  
	public int deQueue() {

		//If mainStack is empty then we have no elements.
		//else return top element of mainStack as we always put oldest entered
		//element at the top of mainStack
		if (mainStack.isEmpty()) return - 1;

		else return mainStack.pop();

	} //end of deQueue
	public NewQueue(int size) {
		//Can use size from argument to create stack   
		mainStack = new MyStack(size);
		tempStack = new MyStack(size);
	} //end of newQueue
	MyStack mainStack;
	MyStack tempStack;

  public static void main(String args[]) {
    
    NewQueue queue = new NewQueue(5);
    
    queue.enQueue(1);
    queue.enQueue(2);
    queue.enQueue(3);
    queue.enQueue(4);
    queue.enQueue(5);
  
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
  }
  
}