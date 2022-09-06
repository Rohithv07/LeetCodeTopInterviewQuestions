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
public class EqualizePrices {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			long[] nums = new long[n];
			long maximumDiff = Long.MIN_VALUE;
			long minimumDiff = Long.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
				maximumDiff = Math.max(maximumDiff, nums[i]);
				minimumDiff = Math.min(minimumDiff, nums[i]);
			}
			if (maximumDiff - minimumDiff > 2 * k) {
				System.out.println("-1");
			} else {
				System.out.println(minimumDiff + k);
			}
		}
	}
}
