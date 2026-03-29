/**
 * @author rohithvazhathody
 * @date 24 Feb 2026
 * Project: CodeforceContestes
 * File: DistrictConnection.java
 */

package practice.onetwo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */
public class DistrictConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			ResultConnection resultConnection = findPossibile(nums);
			String possibility = resultConnection.possibility;
			if (possibility.equals("YES")) {
				System.out.println(possibility);
				int[][] result = resultConnection.direction;
				for (int[] val : result) {
					System.out.println(val[0] + " " + val[1]);
				}
			} else {
				System.out.println(possibility);
			}
		}
		sc.close();
	}

	private static ResultConnection findPossibile(long[] nums) {
		int length = nums.length;
		// Arrays.sort(nums);
		long firstNum  = 1;
		for (int index = 1; index < length; index++) {
			if (nums[index] == nums[0]) {
				firstNum++;
			}
		}
		if (firstNum == length) {
			return new ResultConnection("NO", null);
		}
		int[][] result = new int[length - 1][2];
		int resultIndex = 0;
		for (int index = 1; index < length; index++) {
			int j = 0;
			while (nums[index] == nums[j]) {
				j++;
			}
			result[resultIndex++] = new int[] { index + 1, j + 1 };
		}
		return new ResultConnection("YES", result);
	}

}

class ResultConnection {
	String possibility;
	int[][] direction;

	public ResultConnection(String possibility, int[][] direction) {
		this.possibility = possibility;
		this.direction = direction;
	}
}

/*
 * 
 * 1 2 2 1 3
 * 
 * 1 3 3 5 5 4 1 2
 * 
 * 
 * 
 */
