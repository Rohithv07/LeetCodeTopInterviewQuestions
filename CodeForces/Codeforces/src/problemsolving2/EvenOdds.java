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
public class EvenOdds {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		System.out.println(findKth(n, k));
	}

	private static long findKth(long n, long k) {
		if (k <= (n + 1) / 2) {
			return k * 2 - 1;
		}
		return 2 * (k - (n + 1) / 2);
	}
}
