/*
Given a string, s, return whether or not some permutation of s could form a palindrome.

Ex: Given the following string s…

s = "aeae", return true ("aeea" or "eaae").
Ex: Given the following string s…

s = "computer", return false.
*/


import java.util.*;

public class PalindromePossibility {

	public static boolean isThereAnyPermutationPalindrome(String s) {
		int length = s.length();
		if (length <= 1)
			return true;
		int [] count = new int [26];
		for (char ch : s.toCharArray()) {
			count[ch - 'a'] += 1;
		}
		int howManyOdd = 0;
		for (int number : count) {
			if (number % 2 != 0)
				howManyOdd += 1;
		}
		return howManyOdd <= 1;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		// if atmost one character have odd number of occurance and all other even number of occurance, then they can be rearranged to form a palindrome
		String s = sc.next();
		System.out.println(isThereAnyPermutationPalindrome(s));
	}
}
