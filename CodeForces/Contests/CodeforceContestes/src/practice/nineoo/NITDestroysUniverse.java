package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 24-Dec-2024
 */
public class NITDestroysUniverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n + 1];
			for (int i = 1; i <= n; i++) {
				nums[i] = sc.nextLong();
			}
			System.out.println(findMinSnap(nums, n));
		}
		sc.close();
	}

	private static int findMinSnap(long[] nums, int n) {
		int countOfZero = 0;
		for (int i = 1; i <= n; i++) {
			long num = nums[i];
			if (num == 0) {
				countOfZero++;
			}
		}
		if (countOfZero == 0) {
			return 1;
		}
		if (countOfZero == n) {
			return 0;
		}
		int count = 0;
		long previous = 0;
		for (int i = 1; i <= n; i++) {
			long num = nums[i];
			if (previous == 0 && num != 0) {
				count++;
			}
			previous = num;
		}
		return count >= 2 ? 2 : count;
	}

}
