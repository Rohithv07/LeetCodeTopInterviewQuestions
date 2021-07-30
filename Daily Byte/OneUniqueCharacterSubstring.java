/*
Given a string, s, return the total number of substring within s that contain the same character.
Note: You may assume that s only contains lowercase alphabetical characters.

Ex: Given the following string s…

s = "aabca", return 6 ("a" appears 3 times, "aa" appears 1 time, "b" appears 1 time, and "c" appears 1 time).
*/


import java.util.*;

public class OneUniqueCharacterSubstring {

	public static int sameLetterSubstringCount(String s) {
		// for a string s, there can be (n * (n + 1)) / 2
		if (s == null || s.length() == 0)
			return 0;
		int count = 1;
		int start = 0;
		int result = 0;
		for (int end = 1; end < s.length(); end++) {
			if (s.charAt(start) == s.charAt(end)) {
				count += 1;
			}
			else {
				result += count * (count + 1) / 2;
				count = 1;
				start = end;
			}
		}
		result += count * (count + 1) / 2;
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(sameLetterSubstringCount(s));
	}
}