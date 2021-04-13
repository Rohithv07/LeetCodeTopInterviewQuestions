/*
Given a string array, words, return a list containing all the characters that are common to all the words.
Note: If a character appears multiple times in all the words it should also appear multiple times in your return list.

Ex: Given the following words…

words = ["abc", "ab", "a"], return ["a"].
Ex: Given the following words…

words = ["deef", "ddabee", "eebhk"], return ["e","e"].
*/

import java.util.*;

public class CommonCharacters {

	public static List<Character> findCommonInAll(String [] words, int n) {
		List<Character> result = new ArrayList<>();
		boolean [] primaryCheck = new boolean[26];
		Arrays.fill(primaryCheck, true);
		for (int i = 0; i < n; i++) {
			String s = words[i];
			boolean [] secondaryCheck = new boolean[26];
			for (char ch : s.toCharArray()) {
				if (primaryCheck[ch - 'a'])
					secondaryCheck[ch - 'a'] = true;
			}
			System.arraycopy(secondaryCheck, 0, primaryCheck, 0, 26);
		}
		for (int i = 0; i < 26; i++) {
			if (primaryCheck[i]) {
				char ch = (char)(i + 97);
				result.add(ch);
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String [] words = new String [n];
		for (int i = 0; i < n; i++) {
			words[i] = sc.next();
		}
		System.out.println(findCommonInAll(words, n));
	}
}
