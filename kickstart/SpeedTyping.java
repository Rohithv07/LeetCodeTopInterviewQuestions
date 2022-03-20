/**
 * 
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			String s1 = sc.next();
			String s2 = sc.next();
			int minMoves = findMoves(s1, s2);
			if (minMoves == -1) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + t + ": " + minMoves);
			}
		}
	}

	private static int findMoves(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return -1;
		}
		int moves = 0;
		if (s1.equals(s2)) {
			return 0;
		}
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s2.charAt(j) == s1.charAt(i)) {
				i++;
				j++;
			}
			else {
				while (j < s2.length() && s2.charAt(j) != s1.charAt(i)) {
					j++;
					moves++;
				}
			}
		}
		if (i < s1.length()) {
			return -1;
		}
		while (j < s2.length()) {
			moves++;
			j++;
		}
		return s2.length() - moves == s1.length() ? moves : -1;
	}

}
