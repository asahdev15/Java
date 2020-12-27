package datastructures.other.dynamicprogramming;

public class LongestPalindromicSubstring_DC {

	public static void main(String[] args) {
		LongestPalindromicSubstring_DC lps = new LongestPalindromicSubstring_DC();
		System.out.println("Longest Palindromic Substring: " + lps.findLPSLength("ABCCBUA"));
	}

	public int findLPSLength(String string) {
		return lps_aux(string, 0, string.length() - 1);
	}

	private int lps_aux(String string, int startIndex, int endIndex) {
		//BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
		if (startIndex > endIndex) {
			return 0;
		}
		//BASE CASE - If both the index are at same position then its a palidrome as its 1 character.
		if (startIndex == endIndex) {
			return 1;
		}	
		int c1 = 0;
		if (string.charAt(startIndex) == string.charAt(endIndex)) {
			int remainingLength = endIndex - startIndex - 1;

			// CASE#1 - If index pointed characters matches
			// then we add 2 to the existing known palindrome length only
			// if remaining string is a palindrome too

			if (remainingLength == lps_aux(string, startIndex + 1, endIndex - 1))
				c1 = remainingLength + 2;
		}
		//CASE#2 - Skip one element from beginning
		//CASE#3 - Skip one element from end
		int c2 = lps_aux(string, startIndex + 1, endIndex);
		int c3 = lps_aux(string, startIndex, endIndex - 1);
		//Take the max sized palindrome
		return Math.max(c1, Math.max(c2, c3));
	}

}
