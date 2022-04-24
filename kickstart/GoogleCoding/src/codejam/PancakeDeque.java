/**
 * 
 */

package codejam;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class PancakeDeque {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println("Case #" + t + ": " + differentWays(nums, n));
		}
	}

	private static int differentWays(int[] nums, int n) {
		if (n == 1) {
			return 1;
		}
		int ways = 0;
		int previous = 0;
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int left = nums[low];
			int right = nums[high];
			if (left <= right) {
				if (left >= previous) {
					ways++;
				}
				previous = Math.max(left, previous);
				low++;
			}
			else if (right <= left) {
				if (right >= previous) {
					ways++;
				}
				previous = Math.max(previous, right);
				high--;
			}
		}
		return ways;
	}
}
