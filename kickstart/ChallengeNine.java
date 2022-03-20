/**
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
			String s = sc.next();
			System.out.println("Case #" + t + ": " + findNumber(s));
		}
	}

	private static String findNumber(String s) {
		long totalSum = 0;
		for (char ch : s.toCharArray()) {
			totalSum += (ch - '0');
			totalSum %= 9;
		}
		totalSum = (9 - totalSum) % 9;
		char required = (char) (totalSum + '0');
		boolean point = false;
		boolean fixed = required != '0';
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (required < ch && !point && fixed) {
				sb.append(required);
				point = true;
			}
			fixed = true;
			sb.append(ch);
		}
		if (!point) {
			sb.append(required);
		}
		return sb.toString();
	}
}
