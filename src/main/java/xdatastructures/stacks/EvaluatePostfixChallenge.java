package xdatastructures.stacks;

import java.util.Stack;

class EvaluatePostfixChallenge {

    public static void main(String args[]) {
        System.out.println(evaluatePostFix("921*-8-4+"));
    }

    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (Character.isDigit(character)) {
                stack.push(Character.getNumericValue(character));
            }
            else
            {
                Integer x = stack.pop();
                Integer y = stack.pop();
                switch (character) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                }
            }
        }
        return stack.pop();
    }

}
