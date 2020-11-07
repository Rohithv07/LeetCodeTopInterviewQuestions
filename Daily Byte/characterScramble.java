This question is asked by Amazon. Given two strings, passage and text return whether or not the characters in text can be used to form the given passage.
Note: Each character in text may only be used once and passage and text will only contain lowercase alphabetical characters.

Ex: Given the following passage and text…

passage = "bat", text = "cat", return false.
Ex: Given the following passage and text…

passage = "dog" text = "didnotgo", return true.


import java.util.*;
public class Solution {
	public static boolean characterScramble(String p, String t) {
        if (p.length() > t.length())
            return false;
		Map<Character, Integer> map = new HashMap<>();
		for (char s: p.toCharArray()) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		for (char s: t.toCharArray()) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) - 1);
			}
		}
		for (char c: map.keySet()) {
			if (map.get(c) > 0)
				return false;
		}
		return true;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String p1 = sc.next();
		String t1 = sc.next();
		String p2 = sc.next();
		String t2 = sc.next();
		String p3 = sc.next();
		String t3 = sc.next();
		System.out.println(characterScramble(p1, t1));
		System.out.println(characterScramble(p2, t2));
		System.out.println(characterScramble(p3, t3));
	}
}
