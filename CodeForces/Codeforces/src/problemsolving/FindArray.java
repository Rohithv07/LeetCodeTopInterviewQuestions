/**
 * 
 */
package problemsolving;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class FindArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			int start = 2;
			for (int i = 0; i < n; i++) {
				nums[i] = start++;
			}
			for (int number : nums) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}
