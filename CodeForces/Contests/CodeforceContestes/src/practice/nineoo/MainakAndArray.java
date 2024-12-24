package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 24-Dec-2024
 */
public class MainakAndArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(maxDiff(nums, n));
		}
		sc.close();
	}

	private static int maxDiff(int[] nums, int n) {
		if (n == 1) {
			return 0;
		}
		int max = -1;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, (nums[(i - 1 + n) % n]) - nums[i]);
		}
		for (int i = 0; i < n - 1; i++) {
			max = Math.max(max, nums[i] - nums[0]);
		}
		for (int i = 1; i < n; i++) {
			max = Math.max(max, nums[n - 1] - nums[i]);
		}
		return max;
	}

}

// 99 2 1
// 1 99 2
