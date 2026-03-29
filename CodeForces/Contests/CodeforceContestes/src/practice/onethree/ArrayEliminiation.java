/**
 * @author rohithvazhathody
 * @date 22 Mar 2026
 * Project: CodeforceContestes
 * File: ArrayEliminiation.java
 */

package practice.onethree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class ArrayEliminiation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			List<Integer> possibleK = findPossibleK(nums);
		}
	}

	private static List<Integer> findPossibleK(int[] nums) {
		List<Integer> result = new ArrayList<>();
		return result;
	}

}
