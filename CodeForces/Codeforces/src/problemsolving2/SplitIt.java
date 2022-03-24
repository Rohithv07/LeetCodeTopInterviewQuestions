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
public class SplitIt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			System.out.println(canWeSplit(s, k, n) ? "YES" : "NO");
		}
	}
	
	private static boolean canWeSplit(String s, int k, int n) {
		if (k == 0) {
			return true;
		}
		if (n == 2 * k) {
			return false;
		}
		boolean isNotPossible = false;
		for (int i = 0; i < k; i++) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				isNotPossible = true;
				break;
			}
		}
		return !isNotPossible && n > 2 * k ? true : false;
	}
}
