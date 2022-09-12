/**
 * 
 */
package problemsolving1000;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class StringLCM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String a = sc.next();
			String b = sc.next();
			System.out.println(findDivisible(a, b));
		}
	}

	private static String findDivisible(String a, String b) {
		String s1 = a;
		String s2 = b;
		while (s1.length() != s2.length()) {
			if (s1.length() > s2.length()) {
				s2 += b;
			} else {
				s1 += a;
			}
		}
		if (s1.equals(s2)) {
			return s1;
		}
		return "-1";
	}
}
