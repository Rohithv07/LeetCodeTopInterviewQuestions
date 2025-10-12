package practice.oneone;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 28-Sept-2025
 */
public class MaximumSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int operation = sc.nextInt();
			long[] nums = new long[length];
			long totalSum = 0;
			for (int index = 0; index < length; index++) {
				nums[index] = sc.nextLong();
				totalSum += nums[index];
			}
			long maximumSum = findMaximumSum(nums, operation, totalSum);
			System.out.println(maximumSum);
		}
		sc.close();
	}

	private static long findMaximumSum(long[] nums, int operation, long totalSum) {
		int length = nums.length;
		long maxSum = 0;
		Arrays.sort(nums);
		long[] prefixSum = new long[length];
		prefixSum[0] = nums[0];
		for (int index = 1; index < length; index++) {
			prefixSum[index] = prefixSum[index - 1] + nums[index];
		}
		for (int first = 0; first <= operation; first++) {
			int second = operation - first;
			int left = 2 * first;
			int right = length - second - 1;
			long currentSum = prefixSum[right] - (left == 0 ? 0 : prefixSum[left - 1]);
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}

}
