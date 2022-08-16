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
public class MakeProductEqualOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int test = sc.nextInt();
//		while (test-- > 0) {
//		}
		int n = sc.nextInt();
		long[] nums = new long[n];
		long lessThan0 = 0;
		long equalToZero = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextLong();
			if (nums[i] < 0) {
				lessThan0++;
			} else if (nums[i] == 0) {
				equalToZero++;
			}
		}
		long minCoins = 0;

		for (long num : nums) {
			if (num < 0) {
				minCoins += (-1 - num);
			} else if (num > 0) {
				minCoins += (num - 1);
			} else {
				minCoins += 1;
			}
		}
		if (lessThan0 % 2 != 0 && equalToZero == 0) {
			minCoins += 2;
		}
		System.out.println(minCoins);
	}
}
