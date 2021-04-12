/*
Given a string, s, that contains a valid set of parentheses, return the maximum depth of the parentheses seen at any point of the string.
Note: For example, “abc”, “()”, and “(()), have depths of zero, one, and two respectively.

Ex: Give the following string s…

s = "The(Daily)Byte", return 1.
Ex: Give the following string s…

s = ""The(Daily)Byte((Dot)Dev)"", return 2.
*/

import java.util.*;

public class NestedParenthesesDepth {
	
	public static int findTheDepth(String s) {
		int currentMax = 0;
		int maxResult = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				currentMax += 1;
				if (currentMax > maxResult) {
					maxResult = currentMax;
				}
			}
			else if (ch == ')') {
				if (currentMax < 0)
					return -1;
				currentMax -= 1;
			}
		}
		if (currentMax != 0)
			return -1; // invalid parentheses
		if (maxResult == 0)
			return 0;
		return maxResult;
	}	
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(findTheDepth(s));
	}
}

