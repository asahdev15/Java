package coding.array.other;

import java.util.Stack;

class CheckNGE
{ 
	public static void NextGreaterElement(int [] arr) 
	{ 
		Stack<Integer> s = new Stack<>();
		int nge[] = new int[arr.length]; 

		// iterate for rest of the elements 
		for (int i = arr.length - 1; i >= 0; i--) 
    	{ 
			if (!s.empty()) { 
				while (!s.empty() && s.peek() <= arr[i]) { 
					s.pop(); 
				} 
			} 
			nge[i] = s.empty() ? -1 : s.peek(); 
			s.push(arr[i]); 
		} 
		for(int i = 0; i < arr.length; i++) 
		System.out.println(arr[i] + " --> " + nge[i]); 
	} 

	public static void main(String[] args) 
	{ 
    	int arr[] = {4,6,3,2,8,1,2}; 
		NextGreaterElement(arr); 
	} 
}