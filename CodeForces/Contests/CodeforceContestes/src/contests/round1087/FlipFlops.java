/**
 * @author rohithvazhathody
 * @date 21 Mar 2026
 * Project: CodeforceContestes
 * File: FlipFlops.java
 */

package contests.round1087;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class FlipFlops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			int k = sc.nextInt();
			int [] nums = new int [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			long maxC = findMaxC(nums, c, k);
			System.out.println(maxC);
		}
		sc.close();
	}

	private static long findMaxC(int[] nums, int c, int k) {
		Arrays.sort(nums);
		long maxC = c;
		for (int num : nums) {
			if (num > maxC) {
				break;
			}
			long neededBoost = maxC - num;
			long possible = Math.min(k, neededBoost);
			maxC += num + possible;
			k -= possible;
			
		}
		return maxC;
	}

}
