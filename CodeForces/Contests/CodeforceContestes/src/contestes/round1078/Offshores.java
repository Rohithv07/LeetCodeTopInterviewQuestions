/**
 * @author rohithvazhathody
 * @date 8 Feb 2026
 * Project: CodeforceContestes
 * File: Offshores.java
 */

package contestes.round1078;

import java.util.Scanner;

/**
 * 
 */
public class Offshores {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long x = sc.nextLong();
			long y = sc.nextLong();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			long maxRubles = findMaxRubles(x, y, nums);
			System.out.println(maxRubles);
		}
		sc.close();
	}

	private static long findMaxRubles(long x, long y, long[] nums) {
		long totalTransfer = 0;
		long maxRubles = 0;
		for (long val : nums) {
			totalTransfer += (val / x) * y;
		}
		for (long eachBank : nums) {
			long currentRubles = (totalTransfer - (eachBank / x) * y) + eachBank;
			if (maxRubles < currentRubles) {
				maxRubles = currentRubles;
			}
		}
		return maxRubles;
	}

}
