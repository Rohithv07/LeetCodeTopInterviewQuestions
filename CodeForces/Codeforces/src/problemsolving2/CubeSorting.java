/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class CubeSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(canSort(nums, n) ? "YES" : "NO");
		}
	}

	private static boolean canSort(int[] nums, int n) {
		for (int i = 1; i < n; i++) {
			if (nums[i] >= nums[i - 1]) {
				return true;
			}
		}
		return false;
	}
}
