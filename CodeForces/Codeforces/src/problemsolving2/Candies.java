package problemsolving2;

import java.util.Scanner;

/**
 * 
 * @author rohithvazhathody
 *
 *
 */
public class Candies {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			System.out.println(findTheX(n));
		}
	}

	private static int findTheX(int n) {
		// k ranges from 2 to 29 as 2^30 - 1 > 10^9
		int proper = 0;
		for (int i = 2; i <= 29; i++) {
			int divisor = (1 << i) - 1; // 1 * (2 ^ i) - 1
			if (n % divisor == 0) {
				proper = divisor;
				break;
			}
		}
		return n / proper;
	}
}
