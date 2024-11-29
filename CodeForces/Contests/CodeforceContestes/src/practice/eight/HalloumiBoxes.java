package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 30-Nov-2024
 */
public class HalloumiBoxes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			long[] num = new long[n];
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextLong();
			}
			System.out.println(isPossible(n, k, num) ? "YES" : "NO");
		}
		sc.close();
	}

	private static boolean isPossible(int n, int k, long[] nums) {
		boolean isAlreadySorted = true;
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] > nums[i]) {
				isAlreadySorted = false;
				break;
			}
		}
		if (isAlreadySorted) {
			return true;
		}
		if (k == 1) {
			return false;
		}
		return true;
	}

}

/**
 * 3 10 14 830 10 3 830 14
 */
