/*
You are typing on a computer when all of a sudden you realize you’ve been typing with caps lock on. Given a string s, return a new string containing all of its alphabetical character transformed to lowercase.
Note: Do you not use an built in library functions.

Ex: Given the following string s…

s = "ABC", return "abc".
Ex: Given the following string s…

s = "ABCa", return "abca".
*/


import java.util.*;

public class CapsLock {

	public static String toLowerCase(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if ((int) ch >= 65 && (int) ch <= 90) {
				sb.append((char)(ch + 32));
			}
			else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(toLowerCase(s));
	}
}
