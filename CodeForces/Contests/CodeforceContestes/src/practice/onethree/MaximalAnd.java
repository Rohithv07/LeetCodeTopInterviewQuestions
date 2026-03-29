/**
 * @author rohithvazhathody
 * @date 19 Mar 2026
 * Project: CodeforceContestes
 * File: MaximalAnd.java
 */

package practice.onethree;

import java.util.Scanner;

/**
 * 
 */
public class MaximalAnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int [] nums = new int [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			long maxAnd = findMaxAnd(nums, k);
			System.out.println(maxAnd);
		}
		sc.close();
	}

	private static long findMaxAnd(int[] nums, int k) {
		int length = nums.length;
		if (k == 0) {
			long val = nums[0];
			for (int index = 1; index < length; index++) {
				val = val & nums[index];
			}
			return val;
		}
		long ans = (1 << 32) - 1;
		int [] bits = new int [32];
		for (int val : nums) {
			ans &= val;
			for (int j = 0; j < 32; j++) {
				if ((val & (1 << j)) != 0) {
					bits[j]++;
				}
			}
		}
		for (int i = 30; i >= 0; i--) {
			if (k >= length - bits[i]) {
				ans |= (1 << i);
				k -= length - bits[i];
			}
		}
		
		return ans;
	}

}
