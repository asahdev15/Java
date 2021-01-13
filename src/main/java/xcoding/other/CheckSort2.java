package xcoding.other;

import xdatastructures.stacks.MyStack;

public class CheckSort2 {
    public static void insert(MyStack stack, int value) {
        if(stack.isEmpty()|| value < stack.top())
            stack.push(value);
        else{
            int temp = stack.pop();
            insert(stack,value);
            stack.push(temp);
        }

    }

    public static MyStack sortStack(MyStack stack) {
        if(!stack.isEmpty()) {
            int value = stack.pop();
            sortStack(stack);
            insert(stack,value);
        }
        return stack;
    }

    public static void main(String args[]) {

        MyStack stack = new MyStack(7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
//        stack.showstack(sortStack(stack));

    }

}
