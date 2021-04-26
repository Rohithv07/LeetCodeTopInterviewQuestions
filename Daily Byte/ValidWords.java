/*
Given a string permitted and a string array, words, valid words are strings within words that only contain permitted characters. Return the total number of valid words.

Ex: Given the following permitted and words…

permitted = "abc", words = ["d", "ab", "abce"], return 1.
Ex: Given the following permitted and words…

permitted = "ake", words = ["ail", "kea", "a"], return 2.
*/

import java.util.*;

public class ValidWords {

	public static int countValid(String permitted, String [] words, int n) {
		int count = 0;
		Set<Character> set = new HashSet<>();
		for (char ch :  permitted.toCharArray()) {
			set.add(ch);
		}

		for (String word: words) {
			boolean isAllCharacterPresent = true;
			for (char ch : word.toCharArray()) {
				if (!set.contains(ch)) {
					isAllCharacterPresent = false;
					break;
				}
			}
			if (isAllCharacterPresent)
				count += 1;
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String permitted = sc.next();
		int n = sc.nextInt();
		String [] words = new String [n];
		for (int i=0; i<n; i++) {
			words[i] = sc.next();
		}
		System.out.println(countValid(permitted, words, n));
	}
}
