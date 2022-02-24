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
public class Era {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			int maxNumber = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				if (maxNumber < nums[i]) {
					maxNumber = Math.max(maxNumber, nums[i] - i);
				}
			}
			System.out.println(maxNumber - 1);
		}
	}
}
