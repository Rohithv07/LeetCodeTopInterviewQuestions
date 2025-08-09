package contests;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Aug-2025
 */
public class BogoSort {

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
			int[] shuffled = findShuffled(nums, n);
			for (int index = n - 1; index >= 0; index--) {
				System.out.print(shuffled[index] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int[] findShuffled(int[] nums, int n) {
		if (n == 1) {
			return nums;
		}
		Arrays.sort(nums);
		return nums;
	}

}
