/**
 * 
 */
package starters;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class PresentsForCheffina {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			System.out.println(minCoin(n));
		}
	}

	private static int minCoin(int n) {
		int coin = 0;
		if (n <= 5) {
			return 4;
		}
		if (n % 5 == 0) {
			int divisor = n / 5;
			coin = 4 * divisor;
		}
		else {
			coin = (n % 5) + (n / 5) * 4;
		}
		return coin;
	}
}
