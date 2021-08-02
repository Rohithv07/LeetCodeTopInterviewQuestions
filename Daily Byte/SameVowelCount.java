/*
Given an even length string, s, return whether or not the first half of s and the second half of s contain the same number of vowels.

Ex: Given the following string s…

s = "laptop", return true (there is one vowel in "lap" and one vowel in "top").
Ex: Given the following string s…

s = "computer", return false.
*/

import java.util.*;

public class SameVowelCount {

	public static boolean isSameVowelCount(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int length = s.length();
		int middle = length / 2;
		int firstHalfCount = 0;
		int secondHalfCount = 0;
		for (int i=0; i<length; i++) {
			char currentChar = s.charAt(i);
			if (i < middle) {
				if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
					firstHalfCount += 1;
				}
			}
			else {
				if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
					secondHalfCount += 1;
				}
			}
		}
		return firstHalfCount == secondHalfCount;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(isSameVowelCount(s));
	}
}