package xcoding.other;

import xdatastructures.stacks.MyStack;

class CheckSort {

  //1. Use a second tempStack.
  //2. Pop value from mainStack.
  //3. If the value is greater or equal to the top of tempStack, then push the value in tempStack
  //else pop all values from tempStack and push them in mainStack and in the end push value in tempStack and repeat from step 2.
  //till mainStack is not empty.
  //4. When mainStack will be empty, tempStack will have sorted values in descending order.
  //5. Now transfer values from tempStack to mainStack to make values sorted in ascending order.
  public static MyStack sortStack(MyStack stack, int size) {

    MyStack tempStack = new MyStack(size);

    while (!stack.isEmpty()) {

      int value = stack.pop();

      if (value >= tempStack.top()) {
        tempStack.push(value);
      }
      else {
        while (!tempStack.isEmpty()  && tempStack.top() > value) {
          stack.push(tempStack.pop());
        }
        tempStack.push(value);
      } //end of else
    } //end of while

    //Transfer from tempStack => stack
    while (!tempStack.isEmpty()) {
      stack.push(tempStack.pop());
    }
    
    return stack;

  }//end of sortStack()

  public static void main(String args[]) {

    MyStack stack = new MyStack(7);
    stack.push(2);
    stack.push(97);
    stack.push(4);
    stack.push(42);
    stack.push(12);
    stack.push(60);
    stack.push(23);
//    stack.showstack(sortStack(stack, 7));

  }

}//end of class