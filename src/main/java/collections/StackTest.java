package collections;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        stackTest();
    }

    private static void stackTest(){
        Stack<String> s = new Stack<String>();
        s.push("A");
        s.push("B");
        s.push("C");
        s.push("D");
        System.out.println(s);
        System.out.println("Top : " + s.peek());
        while(!s.isEmpty()){
            System.out.println("Popped : " + s.pop());
        }
        System.out.println(s);
    }

}
