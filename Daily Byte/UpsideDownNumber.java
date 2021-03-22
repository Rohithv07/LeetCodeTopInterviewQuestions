/*
Given an string, num that represents the string form of an integer, return whether or not the number looks the same when turned upside-down.

Ex: Given the following num...

num = “0”, return true.
Ex: Given the following num...

num = “96”, return true.
Ex: Given the following num...

num = “003821”, return false.
*/

import java.util.*;

public class UpsideDownNumber {

	public static boolean isValid(String s) {
		if (s.length() == 0)
			return false;
		for (char ch : s.toCharArray()) {
			if (ch == '2' || ch == '4' || ch == '5' || ch == '7')
				return false;
		}
		return true;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(isValid(s));
	}
}