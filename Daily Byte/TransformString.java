/*
Given two strings, s and t, return whether or not its possible to transform s into t by doing any number of conversions. A single conversion consists of converting all occurrences of one character in s into any other lowercase alphabetical character.
Note: Both s and t will only contain lowercase alphabetical characters and will always contain the same number of characters.

Ex: Given the following s and t…

s = "abc", t = "bbc", return true (convert all "a" characters to "b" characters).
Ex: Given the following s and t…

s = "bbd", t = "cde", return false.
*/

import java.util.*;

public class TransformString {

	public static boolean isPossible(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		int length1 = s1.length();
		int length2 = s2.length();
		int change = 0;
		int [] count = new int [26];
		for (int i=0; i<length1; i++) {
			char current = s1.charAt(i);
			count[current - 'a'] += 1;
		}
		for (int i=0; i<length2; i++) {
			char current = s2.charAt(i);
			count[current - 'a'] -= 1;
		}
		for (int number : count) {
			if (number != 0) {
				change += 1;
			}
		}
		return change == 2;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(isPossible(s1, s2));
	}
}
