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
public class Puzzles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[m];
		for (int i = 0; i < m; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m - n + 1; i++) {
			min = Math.min(min, nums[i + n - 1] - nums[i]);
		}
		System.out.println(min);

	}
}
