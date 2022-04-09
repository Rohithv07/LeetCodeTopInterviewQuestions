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
public class OracAndFactors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long k = sc.nextInt();
			System.out.println(findTheFactor(n, k));
		}
	}

	private static long findTheFactor(long n, long k) {
		if (n % 2 == 0) {
			return n + 2 * k;
		}
		long smallestDivisor = 0;
		for (long i = 2; i <= n; i++) {
			if (n % i == 0) {
				smallestDivisor = i;
				break;
			}
		}
		return n + (2 * (k - 1)) + smallestDivisor;
	}
}
