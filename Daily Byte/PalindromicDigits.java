/*
Given a positive integer, num, return whether or not it forms a palindrome.
Note: You may not transform the number into a string.

Ex: Given the following num…

num = 12321, return true.
Ex: Given the following num…

num = 5393, return false.
*/


import java.util.*;

public class PalindromicDigits {

	public static boolean isPalindrome(int n) {
		if (n == 0)
			return true;
		int temp = n;
		if (n < 0) {
			n *= -1;
		}
		int result = 0;
		while (n > 0) {
			int rem = n % 10;
			result = (result * 10) + rem;
			n /= 10;
		}
		if (temp < 0 && result * -1 == temp) 
			return true;
		if (temp == result)
			return true;
		return false; 
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(isPalindrome(n));
	}
}
