/*

Given two strings s and t, return the index of the first occurrence of t within s if it exists; otherwise, return -1.

Ex: Given the following strings s and t…

s = "abc", t = "a", return 0.
Ex: Given the following strings s and t…

s = "abc", t = "abcd", return -1.

*/



import java.util.*;

public class IndexOf {

	public static int firstOccurance(String s, String t) {
		if (s.length() < t.length())
			return -1;
		int tPoints = 0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == t.charAt(tPoints) && tPoints + 1!= t.length()) {
				tPoints += 1;
			}
			else if (s.charAt(i) == t.charAt(tPoints) && tPoints + 1== t.length()) {
				return i - t.length() + 1;
			}
			else
				tPoints = 0;
		}
		return -1;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		System.out.println(firstOccurance(s, t));
	}
}