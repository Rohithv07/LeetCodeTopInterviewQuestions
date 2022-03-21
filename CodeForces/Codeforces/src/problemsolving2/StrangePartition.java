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
public class StrangePartition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long x = sc.nextLong();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			long[] minMax = findMinMax(nums, x, n);
			System.out.println(minMax[0] + " " + minMax[1]);
		}
	}

	private static long[] findMinMax(long[] nums, long x, int n) {
		long minVal = 0;
		long maxVal = 0;
		for (long num : nums) {
			maxVal += Math.ceil((double) num / (double) x);
			minVal += num;
		}

		return new long[] { (long) Math.ceil((double) minVal / (double) x), maxVal };
	}
}
