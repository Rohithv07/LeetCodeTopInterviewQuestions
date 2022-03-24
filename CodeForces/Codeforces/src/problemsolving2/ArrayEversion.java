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
public class ArrayEversion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findEversionCount(nums, n));
		}
	}

	public static int findEversionCount(int[] nums, int n) {
		int count = 0;
		int max = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] > max) {
				max = nums[i];
				count++;
			}
		}
		return count - 1;
	}
}
