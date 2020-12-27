package datastructures.stacks;

public class MyStack{
  
  private int size;
	private int[] stackArray;
	private int top;
    
  //Stack Constructor
	public MyStack(int s) { //takes size as a parameter
		stackArray = new int[s]; //allocate memory for the array
		size = s;
		top = -1; //when the stack is empty initially
	}
 	
	public static void main(String[] args) {
    
		MyStack stack = new MyStack(10); //instance of class myStack
    System.out.print("You have successfully created a Stack!");



		//output if stack is empty or not
		if(stack.isEmpty())
			System.out.println("Stack is empty");
		else
			System.out.println("Stack is not empty");

		System.out.printf("%n");

		//output if stack is full or not
		if(stack.isFull())
			System.out.println("Stack is full");
		else
			System.out.println("Stack is not full");


		for (int i = 0; i < 5; i++) {
			stack.push(i); //pushes 5 elements (0-4 inclusive) to the stack
		}

		System.out.println("Is Stack full? \n" + stack.isFull());

		for (int i = 0; i < 5; i++) {
			System.out.print(stack.pop()+" "); //pops all 5 elements from the stack and prints them
		}

		System.out.println("\nIs Stack empty? \n" + stack.isEmpty());
	}

	public boolean isEmpty() {
		return top == -1; //returns true if top == -1, stack is empty
	}

	public boolean isFull() {
		return top == size - 1; //returns true if stack is filled upto (size - 1)
	}

	//Return top element
	public int top() {
		if (!isEmpty()) { //not empty
			return stackArray[top];
		}
		else{ //empty
			System.err.println("Stack is Empty");
			return -1;
		}
	}

	public void push(int value) {
		if (isFull()) { //there's no more space in your stack
			System.err.println("Your Stack is full");
			return;
		}
		stackArray[++top] = value; //adds value to the stack and updates the top element
	}

	//Removes and returns the element at top
	public int pop() {
		if (!isEmpty()) {
			return stackArray[top--]; //returns the most recent element added, and updates the value of the top element
		} else { //no element present in the stack to return
			System.err.println("Your Stack is empty");
			return -1;
		}
	}
}