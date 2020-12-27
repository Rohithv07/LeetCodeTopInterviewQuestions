/*
Given a string s, return the length of the longest substring containing at most two distinct characters.
Note: You may assume that s only contains lowercase alphabetical characters.

Ex: Given the following value of s…

s = "aba", return 3.
Ex: Given the following value of s…

s = "abca", return 2.
*/


import java.util.*;

class TwoUniqueCharacter {

	public static int findTheLength(String s) {
		if (s.length() <= 2)
			return s.length();
		// first we are going to take the count of each character
		int end = 0;
		int beginning = 0;
		int count = 0; // counts the unique character
		// the beginning varibale have the pointer which shows the curent substring have at most 2 unique charactes
		Map<Character, Integer> map = new HashMap<>();
		int maxLength = 0;
		while (end < s.length()) {
			char current = s.charAt(end);
			map.put(current, map.getOrDefault(current, 0) + 1);
			if (map.get(current) == 1)
				count += 1;
			end += 1;
		// we need only atmost 2 characters unique
		while (count > 2) {
			char inBetween = s.charAt(beginning);
			map.put(inBetween, map.get(inBetween) - 1);
			if (map.get(inBetween) == 0)
				count -= 1;
			beginning += 1;
		}
		maxLength = Math.max(maxLength, end - beginning);
	}
	return maxLength;
}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(findTheLength(s));
	}
}


// so generally for k unique charcaters, use k in place of 2