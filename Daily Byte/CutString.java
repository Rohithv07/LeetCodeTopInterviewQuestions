/*
Given a string s containing only lowercase characters, return a list of integers representing the size of each substring you can create such that each character in s only appears in one substring.

Ex: Given the following string s…

s = "abacdddecn", return [3, 6, 1]
Ex: Given the following string s…

s = "aba", return [3]
*/


import java.util.*;

public class CutString {

	public static List<Integer> countSubstring(String s) {
		List<Integer> result = new ArrayList<>();
		int length = s.length();
		int aPointer = 0;
		int bPointer = 1;
		while (aPointer < length - 1) {
			if (s.charAt(aPointer) == s.charAt(bPointer)) {
				result.add(bPointer - aPointer + 1);
				aPointer = bPointer + 1;
				bPointer = aPointer + 1;
			}
			else {
				if (bPointer == length - 1) {
					aPointer += 1;
					bPointer = aPointer + 1;
					result.add(1);
				}
				else {
					bPointer += 1;
				}
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(countSubstring(s));
	}
}