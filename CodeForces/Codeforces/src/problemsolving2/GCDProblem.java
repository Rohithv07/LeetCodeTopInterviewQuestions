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
public class GCDProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long[] threeValues = findThreeValues(n);
			System.out.println(threeValues[0] + " " + threeValues[1] + " " + threeValues[2]);
		}
	}

	private static long[] findThreeValues(long n) {
		long c = 1;
		long a = 0;
		long b = 0;
		long remaining = n - c;
		for (long i = 2; i <= remaining / 2; i++) {
			if (gcd(i, remaining - i) == 1) {
				a = i;
				b = remaining - i;
				break;
			}
		}
		return new long[] { a, b, c };
	}

	private static long gcd(long n1, long n2) {
		return n2 == 0 ? n1 : gcd(n2, n1 % n2);
	}
}
