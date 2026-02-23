/**
 * @author rohithvazhathody
 * @date 16 Feb 2026
 * Project: CodeforceContestes
 * File: PalindromeGameEasy.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class PalindromeGameEasy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			String winner = findWinner(s);
			System.out.println(winner);
		}
		sc.close();
	}

	private static String findWinner(String s) {
		if (s.length() == 1) {
			if (s.charAt(0) == '1') {
				return "DRAW";
			}
			return "BOB";
		}
		int countZero = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '0') {
				countZero++;
			}
		}
		if (countZero % 2 == 0 || countZero == 1) {
			return "BOB";
		}
		return "ALICE";
	}

}

/*
 * 
 * 1 0 1 1 0 1
 * 
 * 1 1 1 1 0 1
 * 
 * 1 0 1 1 1 1
 * 
 * 
 * 1 0 0 1
 * 
 * 
 * 1 1 0 1
 * 
 * 1 1 0 1 1
 * 
 * 1 1 1 1 1
 * 
 * 
 * 
 * 1 1 1 0 1 1 1 1 1
 * 
 * 1 1 1 1 0 0 1 1 1
 * 
 * 1 1 1 1 1 1 1 1 1
 * 
 * 
 * 
 * 1 1 0 0 0 0 1 1
 * 
 * 1 1 1 0 0 0 1 1
 * 
 * 1 1 0 0
 * 
 * 
 */
