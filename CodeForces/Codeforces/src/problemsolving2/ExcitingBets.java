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
public class ExcitingBets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long[] result = getGCDAndMove(a, b);
			System.out.println(result[0] + " " + result[1]);
		}
	}

	private static long[] getGCDAndMove(long a, long b) {
		if (a == b) {
			return new long[] { 0, 0 };
		}
		if (a == 0 || b == 0) {
			return new long[] { Math.max(a, b), 0 };
		}
		long gcd = Math.abs(a - b);
		long moves = Math.min(a % gcd, gcd - a % gcd);
		return new long[] { gcd, moves };
	}
}
