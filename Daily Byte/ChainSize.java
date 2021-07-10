/*
You are given a list of words and asked to find the longest chain. Two words (or more) form a chain if a single letter can be added anywhere in a word, s, to form a word, t (where s and t are both words within the list of words you’re given). Return the length of the longest chain you can form.

Ex: Given the following words…

words = ["a", "ab", "abc"], return 3 ("a" can be transformed to "ab" by adding a "b" and "ab" can be transformed by adding a "c" giving a chain length of 3).
Ex: Given the following words…

words = ["a", "abc"], return 1 (both "a" or "abc" form their own chains of size one, they cannot be added together).
*/

import java.util.*;

public class ChainSize {

	public static int maxSize(String [] words) {
		if (words == null || words.length == 0)
			return 0;
		Map<String, Integer> map = new HashMap<>();
		int length = words.length;
		int maxChainSize = 0;
		Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
		for (String word : words) {
			map.put(word, 1);
			for (int i=0; i<word.length(); i++) {
				StringBuilder sb = new StringBuilder(word);
				String currentWord = sb.deleteCharAt(i).toString();
				if (map.containsKey(currentWord) && map.get(currentWord) + 1 > map.get(word)) {
					map.put(word, map.get(currentWord) + 1);
				}
			}
			maxChainSize = Math.max(maxChainSize, map.get(word));
		}
		return maxChainSize;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		String [] words = new String [length];
		for (int i=0; i<length; i++) {
			String word = sc.next();
			words[i] = word;
		}
		System.out.println(maxSize(words));
	}
}