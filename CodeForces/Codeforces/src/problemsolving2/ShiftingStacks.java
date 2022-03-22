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
public class ShiftingStacks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			long sum1 = 0;
			long sum2 = 0;
			boolean possible = true;
			for (int i = 0; i < n; i++) {
				sum1 += i;
				sum2 += nums[i];
				if (sum2 < sum1) {
					possible = false;
				}
			}
			if (possible) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
