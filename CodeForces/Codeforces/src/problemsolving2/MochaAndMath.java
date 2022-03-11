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
public class MochaAndMath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(getMinMaxElement(nums, n));
		}
	}

	private static int getMinMaxElement(int[] nums, int n) {
		int result = nums[0];
		for (int i = 1; i < n; i++) {
			result &= nums[i];
		}
		return result;
	}
}
