package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Jul-2025
 */
public class DifferentDivisors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long d = sc.nextLong();
			long a = findAnswer(d);
			System.out.println(a);
		}
		sc.close();
	}

	private static long findAnswer(long d) {
		long p = findNextPrime(d + 1);
		long q = findNextPrime(p + d);
		return Math.min(p * p * p, p * q);
	}

	private static long findNextPrime(long num) {
		long forward = num;
		while (forward > 0) {
			boolean isPrime = true;
			for (long prime = 2; prime * prime <= forward; prime++) {
				if (forward % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				return forward;
			}
			forward++;
		}
		return 0;
	}

}
