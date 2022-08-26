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
public class LunchRush {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();
		long[][] rest = new long[n][2];
		for (int i = 0; i < n; i++) {
			rest[i][0] = sc.nextLong();
			rest[i][1] = sc.nextLong();
		}
		long max = Long.MIN_VALUE;
		long joy = 0;
		for (long[] r : rest) {
			long f = r[0];
			long t = r[1];
			if (t < k) {
				joy = f;

			} else {
				joy = f - t + k;
			}
			max = Math.max(max, joy);
		}
		System.out.println(max);
	}
}
