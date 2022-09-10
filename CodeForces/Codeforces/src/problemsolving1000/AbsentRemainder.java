/**
 * 
 */
package problemsolving1000;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class AbsentRemainder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int minimum = Integer.MAX_VALUE;
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				minimum = Math.min(minimum, nums[i]);
			}
			for (int i = 0, k = 0; k < n / 2; i++) {
				if (nums[i] != minimum) {
					System.out.println(nums[i] + " " + minimum);
					k++;
				}
			}
		}
	}
}
