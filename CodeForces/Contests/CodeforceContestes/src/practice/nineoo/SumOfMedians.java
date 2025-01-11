package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 11-Jan-2025
 */
public class SumOfMedians {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] nums = new int[n * k + 1];
			for (int i = 1; i <= n * k; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findMaxSum(nums, n, k));
		}
		sc.close();
	}

	private static long findMaxSum(int[] nums, int n, int k) {
		long totalSum = 0;
		long limit = (n) / 2 + 1;
		int z = n * k + 1;
		for (int i = 0; i < k; i++) {
			z -= limit;
			totalSum += nums[z];
		}
		return totalSum;
	}

}
