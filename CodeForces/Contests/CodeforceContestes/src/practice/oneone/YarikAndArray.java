package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 20-Aug-2025
 */
public class YarikAndArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			int maxSubarraySum = findMaxSum(nums, n);
			System.out.println(maxSubarraySum);
		}
		sc.close();
	}

	private static int findMaxSum(int[] nums, int n) {
		if (n == 1) {
			return nums[0];
		}
		int maxSum = nums[0];
		int minimum = Math.min(0, nums[0]);
		int runningSum = nums[0];
		for (int index = 1; index < n; index++) {
			if (Math.abs(nums[index] % 2) == Math.abs(nums[index - 1] % 2)) {
				minimum = 0;
				runningSum = 0;
			}
			runningSum += nums[index];
			maxSum = Math.max(maxSum, runningSum - minimum);
			minimum = Math.min(minimum, runningSum);
		}
		return maxSum;
	}

}
