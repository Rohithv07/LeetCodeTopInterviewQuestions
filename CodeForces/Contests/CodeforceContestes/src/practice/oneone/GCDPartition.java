package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 20-Oct-2025
 */
public class GCDPartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			long totalSum = 0;
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
				totalSum += nums[index];
			}
			long maximumScore = findMaximumScore(nums, totalSum);
			System.out.println(maximumScore);
		}
		sc.close();
	}

	private static long findMaximumScore(long[] nums, long totalSum) {
		int length = nums.length;
		long prefixSum = 0;
		long answer = 0;
		for (int index = 0; index < length - 1; index++) {
			prefixSum += nums[index];
			long remaining = totalSum - prefixSum;
			answer = Math.max(answer, findGCD(prefixSum, remaining));
		}
		return answer;
	}

	private static long findGCD(long a, long b) {
		if (b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}

}

/**
 * 7 7 7 7 7 7
 * 
 * 7 14 21 28 35 42 42 35 28 21 14 7
 * 
 */
