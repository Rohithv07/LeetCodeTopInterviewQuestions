/*
Given an array of words, return the length of the longest phrase, containing only unique characters, that you can form by combining the given words together.

Ex: Given the following words…

words = ["the","dog","ran"], return 9 because you can combine all the words, i.e. "the dog ran" since all the characters in the phrase are unique.
Ex: Given the following words…

words = ["the","eagle","flew"], return 4 because "flew" is the longest phrase you can create without using duplicate characters.
*/

import java.util.*;

class LongestPhrase {

	public static int findThePhraseLength(String [] array) {
		if (array.length == 0)
			return 0;
		Set<Character> checkingUniqueness = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (String s : array) {
			for (char ch : s.toCharArray()) {
				checkingUniqueness.add(ch);
			}
			if (s.length() == checkingUniqueness.size()) {
				sb.append(s);
				sb.append(" ");
			}
			checkingUniqueness.clear();
		}
		sb.deleteCharAt(sb.length() - 1);
		String currentPossible = sb.toString();
		String currentPossible2 = currentPossible.replaceAll(" ", "");
		for (char ch : currentPossible2.toCharArray())
			checkingUniqueness.add(ch);
		System.out.println(currentPossible2.length() + " " + checkingUniqueness.size());
		if (currentPossible2.length() == checkingUniqueness.size())
			return currentPossible2.length();
		String [] splittedArray = currentPossible.split(" ");
		int maximumLength = 0;
		for (String s : splittedArray) {
			int currentStringLength = s.length();
			maximumLength = Math.max(maximumLength, currentStringLength);
		}
		return maximumLength;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String [] array = new String[n];
		for (int i=0; i<n; i++)
			array[i] = sc.next();
		System.out.println(findThePhraseLength(array));
	}
}