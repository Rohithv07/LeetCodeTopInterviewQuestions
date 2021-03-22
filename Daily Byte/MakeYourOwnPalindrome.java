/*
Given a string, s, which consists of only lowercase alphabetical characters, return the length of the longest palindrome you can form using its letters.

Ex: Given the following s...

s = “aa”, return 2.
Ex: Given the following s...

s = “abbcaadabac”, return 9.
*/

import java.util.*;

public class MakeYourOwnPalindrome {

	public static int getMaxLength(String s) {
		int length = s.length();
		if (length < 2)
			return length;
		int [] count = new int [26];
		for (char ch : s.toCharArray()) {
			count[ch - 'a'] += 1;
		}
		int result = 0;
		for (int c : count) {
			result = result + c / 2 * 2;
			if (result % 2 == 0 && c % 2 == 1)
				result += 1;
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(getMaxLength(s));
	}
}