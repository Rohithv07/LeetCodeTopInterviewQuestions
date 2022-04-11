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
public class YetAnotherTetrisProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(isPossibleToPlace(nums, n) ? "YES" : "NO");
		}
	}

	private static boolean isPossibleToPlace(int[] nums, int n) {
		if (n == 1) {
			return true;
		}
		boolean even = false;
		boolean odd = false;
		for (int num : nums) {
			if (num % 2 == 0) {
				even = true;
			} else {
				odd = true;
			}
			if (even == true && odd == true) {
				return false;
			}
		}
		return true;
	}
}
