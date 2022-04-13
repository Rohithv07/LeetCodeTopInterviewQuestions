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
public class Sales {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int total = 0;
		for (int i = 0; i < m; i++) {
			if (nums[i] < 0)
				total += (nums[i]);
		}
		System.out.println(Math.abs(total));
	}
}
