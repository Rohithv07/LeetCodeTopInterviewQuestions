/*
Given a string, s, return the length of the longest substring that only contains one unique character.
Note: s is non-empty and it is guaranteed there is a single answer.

Ex: Given the following string s…

s = "aabc", return 2 ("aa" is length 2).
Ex: Given the following string s…

s = "abcabbccabccc", return 3.
*/

import java.util.*;

public class SingleCharacterSubstring {

	public static int longestSingleUniqueCharacterWord(String s, int k) {
		int result = 0;
		int startingIndex = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int j=0; j<s.length(); j++) {
			if (!map.containsKey(s.charAt(j)))
				map.put(s.charAt(j), 1);
			else
				map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
			if (map.size() <= k) {
				result = Math.max(result, j - startingIndex + 1);
			}
			else {
				while (map.size() > k) {
					char ch = s.charAt(startingIndex);
					int count = map.get(ch);
					if (count == 1)
						map.remove(ch);
					else 
						map.put(ch, map.get(ch) - 1);
					startingIndex += 1;	
				}
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt(); // k no of unique characters, here k = 1
		System.out.println(longestSingleUniqueCharacterWord(s, k));
	}
}
