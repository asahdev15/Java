package xdatastructures.stacks;

import java.util.Stack;

public class MinStack {

    public static void main(String args[]) {

        MinStack stack = new MinStack(6);
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


    int maxSize;
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    //constructor
    public MinStack(int maxSize) {
        //We will use two stacks mainStack to hold origional values
        //and minStack to hold minimum values. Top of minStack will always
        //be the minimum value from mainStack
        this.maxSize = maxSize;
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    //removes and returns value from stack
    public int pop(){
        //1. Pop element from minStack to make it sync with mainStack,
        //2. Pop element from mainStack and return that value
        minStack.pop();
        return mainStack.pop();
    }
    //pushes value into the stack
    public void push(Integer value){
        //1. Push value in mainStack and check value with the top value of minStack
        //2. If value is greater than top, then push top in minStack
        //else push value in minStack
        mainStack.push(value);
        if(!minStack.isEmpty() && minStack.peek() < value)
            minStack.push(minStack.peek());
        else
            minStack.push(value);
    }
    //returns minimum value in O(1)
    public int min(){
        return minStack.peek();
    }
}