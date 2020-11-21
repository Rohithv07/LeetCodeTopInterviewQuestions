This question is asked by Amazon. Given a string s remove all the vowels it contains and return the resulting string.
Note: In this problem y is not considered a vowel.

Ex: Given the following string s…

s = "aeiou", return ""
Ex: Given the following string s…

s = "byte", return "byt"
Ex: Given the following string s…

s = "xyz", return "xyz"


import java.util.*;

public class Solution {
	public static String removeVowels(String s) {
		if (s.length() == 0)
			return "";
		// add all the vowels lowercase into the set
		Set<Character>set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		StringBuilder sb = new StringBuilder();
		// now traverse through the string and check for vowels
		for (int i=0; i<s.length(); i++) {
			char currentLetter = s.charAt(i);
			if (!set.contains(currentLetter))
				sb.append(currentLetter);
		}
		return sb.toString();
	}
	public static void main(String [] args) {
		String s = "byte";
		System.out.println(removeVowels(s));
	}
}