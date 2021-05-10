/*
Given a string, s, return the total number of substrings that only contain one distinct character.

Ex: Given the following string s…

s = "aabbc", return 7. ("a", "aa", "a", "b", "bb", "b", "c").
Ex: Given the following string s…

s = "aaa", return 6.
*/

import java.util.*;

public class DistinctCharacterSubstring {

	public static int getDistinctCharacter(String s) {
		if (s.length() == 1)
			return 1;
		int count = 1;
		int result = 0;
		char currentChar = s.charAt(0);
		for (int i=1; i<s.length(); i++) {
			if (s.charAt(i) != currentChar) {
				result += count * (count + 1) / 2;
				currentChar = s.charAt(i);
				count = 1;
			}
			else {
				count += 1;
			}
		}
		result += count * (count + 1) / 2; // dealing with the last issue
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(getDistinctCharacter(s));
	}
}