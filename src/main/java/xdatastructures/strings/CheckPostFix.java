package xdatastructures.strings;

import xdatastructures.stacks.MyStack;

class CheckPostFix {

	public static int evaluatePostFix(String exp) {

		MyStack stack = new MyStack(exp.length());

		//1.Scan expression character by character,
		//2.If character is a number push it in stack
		//3.If character is operator then pop two elements from stack
		//perform the operation and put the result back in stack
		//At the end, Stack will contain result of whole expression.
		for (int i = 0; i < exp.length(); i++) {

			char character = exp.charAt(i);

			if (!Character.isDigit(character)) {
				int x = stack.pop();
				int y = stack.pop();

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
			} //end of if
			else stack.push(Character.getNumericValue(character));

		} //end of for    
		return stack.pop();
	} //end of function
  
  public static void main(String args[]) {
  
    System.out.println(CheckPostFix.evaluatePostFix("921*-8-4+"));
    
  }
  
}