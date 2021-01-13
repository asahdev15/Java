package xdatastructures.stacks;

class NewStack {

  //We will use two stacks mainStack to hold origional values
  //and minStack to hold minimum values. Top of minStack will always 
  //be the minimum value from mainStack
  MyStack mainStack;
  MyStack minStack;

  public NewStack(int size) {
    mainStack = new MyStack(size);
    minStack = new MyStack(size);
  }

  //Removes and return value from newStack
  //1. Pop element from minStack to make it sync with mainStack,
  //2. Pop element from mainStack and return that value.	
  public int pop() {

    minStack.pop();
    return mainStack.pop();

  }

  //Pushes values into newStack  
  //1. Push value in mainStack and check value with the top value of minStack
  //2. If value is greater than top, then push top in minStack
  //else push value in minStack.
  public void push(int value) {

    mainStack.push(value);

    if (value > minStack.top() && !minStack.isEmpty()) {
      minStack.push(minStack.top());
    }
    else minStack.push(value);
  }

  //Returns minimum value from newStack in O(1) Time  
  public int min() {
    return minStack.top();
  }

  public static void main(String args[]) {

    NewStack stack = new NewStack(6);
    stack.push(5);
    stack.push(2);
    stack.push(4);
    stack.push(1);
    stack.push(3);
    stack.push(9);

    System.out.println(stack.min());

    stack.pop();
    stack.pop();
    stack.pop();

    System.out.println(stack.min()); 

  }

}