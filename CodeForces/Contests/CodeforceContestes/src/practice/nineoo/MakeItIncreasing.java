package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 25-Dec-2024
 */
public class MakeItIncreasing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long nums[] = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			System.out.println(minOperatio(nums, n));
		}
		sc.close();
	}

	private static int minOperatio(long[] nums, int n) {
		int minOp = 0;
		if (n == 1) {
			return minOp;
		}
		boolean isAlreadyIncreasing = true;
		for (int i = 1; i < n; i++) {
			if (nums[i] <= nums[i - 1]) {
				isAlreadyIncreasing = false;
				break;
			}
		}
		if (isAlreadyIncreasing) {
			return 0;
		}
		for (int i = n - 2; i >= 0; i--) {
			while (nums[i] >= nums[i + 1] && nums[i] > 0) {
				nums[i] /= 2;
				minOp++;
			}
			if (nums[i] == nums[i + 1]) {
				return -1;
			}
		}
		return minOp;
	}

}
