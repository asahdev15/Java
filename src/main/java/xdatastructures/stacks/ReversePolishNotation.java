package xdatastructures.stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) throws Exception{
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) throws Exception{
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<Integer> stck = new Stack<>();
        for(String item : tokens){
            if(operators.contains(item)){
                Integer op1 = stck.pop();
                Integer op2 = stck.pop();
                switch(item){
                    case "+": stck.push(op2 + op1);break;
                    case "-": stck.push(op2 - op1);break;
                    case "*": stck.push(op2 * op1);break;
                    case "/": stck.push(op2 / op1);break;
                }
            }else{
                stck.push(Integer.parseInt(item));
            }
        }
        return stck.pop();
    }

}
