/*
Given a string, s, make it acceptable. An acceptable string is a string that contains no two adjacent characters that are the same with one letter being capitalized and the other being lowercased.
Note: An empty string is acceptable and only one distinct answer will exist.

Ex: Given the following string s…

s = "Aabb", return "bb".
Ex: Given the following string s…

s = "AabBcC", return "".
*/

import java.util.*;

public class AcceptableString {

	public static String acceptedString(String s) {
		if (s == null || s.length() == 0)
			return "";
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int next = start + 1;
		while (next < length) {
			if (s.charAt(start) + 32 == s.charAt(next) || s.charAt(start) - 32 == s.charAt(next)) {
				start = next + 1;
				next = start + 1;
			}
			else {
				sb.append(s.charAt(start));
				if (next + 1 == length)
					sb.append(s.charAt(next));
				start += 1;
				next += 1;
			}
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(acceptedString(s));
	}
}