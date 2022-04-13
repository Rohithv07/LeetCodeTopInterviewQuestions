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
public class KefaAndTheFirstSteps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(increasingLength(nums, n));
	}

	private static int increasingLength(int[] nums, int n) {
		if (n == 1) {
			return 1;
		}
		int length = 1;
		int track = 1;
		for (int i = 1; i < n; i++) {
			if (nums[i] >= nums[i - 1]) {
				track++;
			} else {
				track = 1;
			}
			length = Math.max(length, track);
		}
		return length;
	}
}
