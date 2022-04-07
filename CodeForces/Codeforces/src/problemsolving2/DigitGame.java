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
public class DigitGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(whoWins(s, n));
		}
	}

	private static char whoWins(String s, int n) {
		if (n == 1) {
			return (s.charAt(0) - '0') % 2 == 0 ? '2' : '1';
		}
		boolean isOdd = false;
		boolean isEven = false;
		for (int i = 1; i <= n; i++) {
			int num = s.charAt(i - 1) - '0';
			if (i % 2 == 0) {
				isEven |= (num % 2 == 0);
			} else {
				isOdd |= (num % 2 == 1);
			}
		}
		if (n % 2 == 0) {
			return isEven ? '2' : '1';
		}
		return isOdd ? '1' : '2';
	}
}
