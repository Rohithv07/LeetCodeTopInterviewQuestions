/**
 * 
 */
package starters;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class JumpToSibling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findMinJump(nums, n));
		}
	}

	private static int findMinJump(int[] nums, int n) {
		if (n == 1) {
			return 0;
		}
		int jump = 0;
		int[] temp = new int[n];
		int[] minJumps = new int[n];
		int max = 0;
		// for last 2 pos
		if ((nums[0] % 2 == nums[n - 1] % 2)) {
			for (int i = 1; i < n; i++) {
				if (nums[i] % 2 == nums[0] % 2) {
					jump++;
				}
			}
		} else {
			for (int i = 1; i < n; i++) {
				if (nums[i] % 2 != nums[0] % 2) {
					temp[i] = temp[i - 1] + 1;
				} else {
					temp[i] = temp[i - 1];
				}
			}
			jump = temp[n - 1];
			for (int i = 1; i < n; i++) {
				if (nums[i] % 2 == nums[0] % 2) {
					max++;
					jump = Math.min(jump, max + temp[n - 1] - temp[i]);
				}
			}
		}
		return jump;
	}
}
