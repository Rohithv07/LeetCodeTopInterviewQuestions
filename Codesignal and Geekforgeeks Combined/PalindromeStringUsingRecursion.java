import java.util.*;

public class PalindromeStringUsingRecursion {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println("Is it a palindrome " + isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		String reverse = findReverse(s);
		return s.equals(reverse);
	}

	public static String findReverse(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		return s.charAt(s.length() - 1) + findReverse(s.substring(0, s.length() - 1));
	}
}