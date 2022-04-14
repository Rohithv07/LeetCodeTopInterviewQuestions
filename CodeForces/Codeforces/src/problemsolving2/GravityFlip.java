/**
 * 
 */
package problemsolving2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class GravityFlip {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int [] result = findAfterFlip(nums, n);
		for (int num : result) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	private static int[] findAfterFlip(int[] nums, int n) {
		Arrays.sort(nums);
		return nums;
	}
}
