/*
Given a string s, return the length of the longest substring that contains only unique characters.

Ex: Given the following string s…

s = "ababbc", return 2.
Ex: Given the following string s…

s = "abcdssa", return 5.
*/


import java.util.*;

public class NoRepitions {

	public static int longestSubstringWithNoRepitingCharacters(String s) {
		if (s.length() == 1)
			return 1;
		int aPointer = 0;
		int bPointer = 0;
		int maxLength = 0;
		int length = s.length();
		Set<Character> set = new HashSet<>();
		while (bPointer < length) {
			if (!set.contains(s.charAt(bPointer))) {
				set.add(s.charAt(bPointer++));
				maxLength = Math.max(maxLength, set.size());
			}
			else {
				set.remove(s.charAt(aPointer++));
			}
		}
		return maxLength;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(longestSubstringWithNoRepitingCharacters(s));
	}
}