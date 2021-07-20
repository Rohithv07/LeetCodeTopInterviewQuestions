/*
Given an encoded string, s, return its decoded representation. The string s will be encoded as follows N[letters], meaning that the letters should be repeated N times in the decoded representation.
Note: You may assume s always encoded correctly (i.e. correct formatting of brackets, only positive values outside the brackets, and always lowercase alphabetical characters inside the brackets).

Ex: Given the following string s…

s = "3[a]2[b]1[c]", return "aaabbc" ("a" is repeated 3 times, "b" is repeated 2 times, and "c" is repeated 1 time).
*/


import java.util.*;

public class DecodeCharacters {

	public static String decodeToOriginal(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = 0;
		int length = s.length();
		int number = 0;
		while (index < length) {
			while (Character.isDigit(s.charAt(index))) {
				number += (number * 10) + (s.charAt(index) - '0');
				index += 1;
			}
			if (s.charAt(index) == '[') {
				index++;
				StringBuilder current = new StringBuilder();
				while (Character.isLetter(s.charAt(index))) {
					current.append(s.charAt(index));
					index++;
				}
				for (int i=0; i<number; i++) {
					sb.append(current);
				}
			}
			else {
				number = 0;
				index++;
			}
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(decodeToOriginal(s));
	}
}


/*

[3] a [] -> aaa
[2] b [] ->

*/