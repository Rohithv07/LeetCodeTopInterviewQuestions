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
public class GCDSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			while (findGCD(n, sum(n)) == 1) {
				n++;
			}
			System.out.println(n);
		}
	}

	private static long findGCD(long n1, long n2) {
		if (n2 == 0) {
			return n1;
		}
		return findGCD(n2, n1 % n2);
	}

	private static long sum(long n) {
		long sum = 0;
		while (n > 0) {
			sum += (n % 10);
			n /= 10;
		}
		return sum;
	}
}
