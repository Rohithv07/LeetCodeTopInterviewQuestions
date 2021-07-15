/*
Given a string, s, return the length of the longest substring that contains every vowel occurring an even number of times.
Note: You may assume s only contains lowercase alphabetical characters and the vowels you must account for are a, e, i, o, and u.

Ex: Given the following string s…

s = "aeiouaeioua", return 10 (the last 'a' cannot count).
Ex: Given the following string s…

s = "bbb", return 3 (all vowels occur an even number of times, i.e. zero times each).
*/

import java.util.*;

public class EvenVowelSubstring {

	public static int substringWithEvenVowel(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Map<Character, Integer> vowelToIndex = new HashMap<>();
		vowelToIndex.put('a', 0);
		vowelToIndex.put('e', 1);
		vowelToIndex.put('i', 2);
		vowelToIndex.put('o', 3);
		vowelToIndex.put('u', 4);
		int state = 0;
		int maxLength = 0;
		Map<Integer, Integer> stateToIndex = new HashMap<>();
		stateToIndex.put(0, -1);
		for (int i=0; i<s.length(); i++) {
			char current = s.charAt(i);
			if (vowelToIndex.containsKey(current)) {
				state ^= (1 << vowelToIndex.get(current));
			}
			stateToIndex.putIfAbsent(state, i);
			maxLength = Math.max(maxLength, i - stateToIndex.get(state));
		}
		return maxLength;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(substringWithEvenVowel(s));
	}
}