/**
 * 
 */
package starters;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class AdminsAndShopping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int shop = sc.nextInt();
			int admin = sc.nextInt();
			int[] nums = new int[shop];
			for (int i = 0; i < shop; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findMinimumHour(nums, shop, admin));
		}

	}

	private static int findMinimumHour(int[] nums, int shop, int admin) {
		Arrays.sort(nums);
		int minimum = nums[0];
		return Math.max(shop, (int) (Math.ceil((double)admin / (double)minimum)));
	}
}
