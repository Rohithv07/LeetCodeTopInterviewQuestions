package practice.nineoo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Dec-2024
 */
public class BalancedRound {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			Arrays.sort(nums);
			System.out.println(findMinRound(nums, n, k));
		}
		sc.close();
	}

	private static long findMinRound(long[] nums, int n, long k) {
		long count = 1;
		long maxCount = 1;
		for (int i = 1; i < n; i++) {
			long previous = nums[i - 1];
			long current = nums[i];
			if (Math.abs(previous - current) > k) {
				count = 1;
			} else {
				count++;
			}
			maxCount = Math.max(maxCount, count);
		}
		return n - maxCount;
	}

}

/*
 * 1 5 10 1 5
 */
