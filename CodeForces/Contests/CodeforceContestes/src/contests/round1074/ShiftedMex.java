/**
 * @author rohithvazhathody
 * @date 18 Jan 2026
 * Project: CodeforceContestes
 * File: ShiftedMex.java
 */

package contests.round1074;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class ShiftedMex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			int maxVal = findMaxVal(nums, n);
			System.out.println(maxVal);
		}
		sc.close();
	}

	private static int findMaxVal(int[] nums, int n) {
		if (n == 1) {
			return 1;
		}
		Arrays.sort(nums);
		int longestRun = 1;
		int max = 1;
		for (int index = 1; index < n; index++) {
			if (nums[index] == nums[index - 1]) {
				continue;
			}
			if (nums[index] == nums[index - 1] + 1) {
				longestRun++;
			} else {
				max = Math.max(max, longestRun);
				longestRun = 1;
			}
		}
		max = Math.max(max, longestRun);
		return max;
	}

}

/**
 * -1 1 2 3 5 6 0 2 3
 * 
 * 1 2 3 4 5 6
 * 
 * 0 3 5 7 10 12
 * 
 * 
 * 
 */