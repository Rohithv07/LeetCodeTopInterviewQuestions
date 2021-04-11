/*
Given a string s, reverse all of its characters that are letters and return the resulting string.

Ex: Given the following string s…

s = "abc*a", return "acb*a".
Ex: Given the following string s…

s = "Ab&e]a-Ta", return "aT&a]e-bA".
*/


import java.util.*;

public class ReverseLetters {

	public static String reverseOnlyLetters(String s) {
		char [] stringArray = s.toCharArray();
		StringBuilder onlyLetters = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (Character.isLetter(ch))
				onlyLetters.append(ch);
		}
		String reversedLetters = onlyLetters.reverse().toString();
		int onlyLettersIndex = 0;
		for (int i=0; i<stringArray.length; i++) {
			if (Character.isLetter(stringArray[i])) {
				stringArray[i] = reversedLetters.charAt(onlyLettersIndex++);
			}
		}
		return String.valueOf(stringArray);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(reverseOnlyLetters(s));
	}
}

