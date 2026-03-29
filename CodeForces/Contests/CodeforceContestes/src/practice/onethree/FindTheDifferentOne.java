/**
 * @author rohithvazhathody
 * @date 26 Feb 2026
 * Project: CodeforceContestes
 * File: FindTheDifferentOne.java
 */

package practice.onethree;

import java.util.Scanner;

/**
 * 
 */
public class FindTheDifferentOne {

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
			int q = sc.nextInt();
			int[][] query = new int[q][2];
			for (int index = 0; index < q; index++) {
				query[index][0] = sc.nextInt() - 1;
				query[index][1] = sc.nextInt() - 1;
			}
			int[][] result = findDiffIndex(nums, query);
			for (int[] num : result) {
				System.out.print(num[0] + " " + num[1]);
				System.out.println();
			}
		}
		sc.close();
	}

	private static int[][] findDiffIndex(int[] nums, int[][] query) {
		int length = nums.length;
		int[] previousSeen = new int[length];
		int[][] result = new int[query.length][2];
		previousSeen[0] = -1;
		for (int index = 1; index < length; index++) {
			if (nums[index] != nums[index - 1]) {
				previousSeen[index] = index - 1;
			} else {
				previousSeen[index] = previousSeen[index - 1];
			}
		}
		for (int index = 0; index < query.length; index++) {
			int left = query[index][0];
			int right = query[index][1];
			int maxR = previousSeen[right];
			if (left > maxR) {
				result[index] = new int[] { -1, -1 };
			} else {
				result[index] = new int[] { maxR + 1, right + 1 };
			}
		}
		return result;
	}

}
