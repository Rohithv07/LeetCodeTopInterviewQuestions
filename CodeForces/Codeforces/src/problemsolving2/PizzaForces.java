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
public class PizzaForces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			System.out.println(getMinutes(n));
		}
	}

	private static long getMinutes(long n) {
		if (n <= 6) {
			return 15;
		}
		if (n % 2 == 1) {
			n = n + 1;
		}
		return n / 2 * 5;
	}
}
