/**
 * 
 */
package codejam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class ControlledInflation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int[][] nums = new int[n][p];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < p; j++) {
					nums[i][j] = sc.nextInt();
				}
			}
			System.out.println("Case #" + t + ": " + findButtonPress(nums, n, p));
		}
	}

	private static long findButtonPress(int[][] nums, int n, int p) {
		final long MOD = (long) (1e9 + 7);
		long keyPress = 0;
		long current = 0;
		for (int[] num : nums) {
			Arrays.sort(num);
			int first = num[0];
			int last = num[p - 1];
			if (current > first && current < last) {
				if (current - first <= last - current) {
					keyPress += (current - first) + (last - first);
					current = last;
				}
				else {
					keyPress += (last - current) + (last - first);
					current = first;
				}
//				if (current - first > current - last) {
//					keyPress += (current - last) + (last - first);
//					current = first;
//				} else {
//					keyPress += (current - first) + (last - first);
//					current = last;
//				}
			} else {
				if (current < last) {
					keyPress += last - current;
					current = last;
				} else {
					keyPress += current - first;
					current = first;
				}
			}
		}
		return keyPress;
	}
}
