/**
 * 
 */
package problemsolving;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class ReplacingElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			if (nums[0] + nums[1] <= d || nums[n - 1] <= d) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}

	}
}
