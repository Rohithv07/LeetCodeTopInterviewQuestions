/**
 * 
 */

// showing WA
package longChallenge;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class InterestingSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			long[] result = findInterestingValues(nums, n);
			System.out.println(result[0] + " " + result[1]);
		}
	}

	private static long[] findInterestingValues(long[] nums, int n) {
		long checkMin = Long.MAX_VALUE;
		long minValue = Long.MAX_VALUE;
		long maxValue = Long.MIN_VALUE;
		for (long num : nums) {
			if (num >= 0 && checkMin > num) {
				checkMin = num;
			}
			minValue = Math.min(minValue, num);
			maxValue = Math.max(maxValue, num);
		}
		if (checkMin == Long.MAX_VALUE) {
			return new long[] { maxValue * maxValue, minValue * minValue };
		} else {
			if (checkMin < 0) {
				return new long[] { minValue * maxValue, Math.max(maxValue * maxValue, minValue * minValue) };
			} else {
				return new long[] { minValue * minValue, maxValue * maxValue };
			}
		}
	}
}
