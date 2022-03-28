/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class NonSubstringSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int numberOfQueries = sc.nextInt();
			String s = sc.next();
			for (int i = 0; i < numberOfQueries; i++) {
				System.out.println(isSubstringPresent(s, sc.nextInt(), sc.nextInt()) ? "YES" : "NO");
			}
		}
	}

	private static boolean isSubstringPresent(String s, int q1, int q2) {
		String substring = s.substring(q1 - 1, q2);
		char firstChar = substring.charAt(0);
		char secondChar = substring.charAt(substring.length() - 1);
		for (int i = 0; i < s.length(); i++) {
			if (i == q1 - 1) {
				continue;
			}
			if (s.charAt(i) == firstChar && i < q1 - 1) {
				return true;
			}
			if (s.charAt(i) == secondChar && i > q2 - 1) {
				return true;
			}
		}
		return false;
	}
}
