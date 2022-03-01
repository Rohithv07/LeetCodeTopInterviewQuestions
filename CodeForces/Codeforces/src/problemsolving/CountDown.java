/**
 * 
 */
package problemsolving;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class CountDown {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			int operation = 0;
			for (int i = 0; i < n; i++) {
				int currentDigit = s.charAt(i) - '0';
				operation += currentDigit;
				if (i != n - 1 && currentDigit != 0) {
					operation++;
				}
			}
			System.out.println(operation);
		}
	}
}
