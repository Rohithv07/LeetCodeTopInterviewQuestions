/**
 * @author rohithvazhathody
 * @date 18 Jan 2026
 * Project: CodeforceContestes
 * File: OutOfMemoryError.java
 */

package contests.round1074;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */
public class OutOfMemoryError {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int h = sc.nextInt();
			long[] nums = new long[n];
			int[][] ops = new int[m][2];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			for (int index = 0; index < m; index++) {
				ops[index][0] = sc.nextInt();
				ops[index][1] = sc.nextInt();
			}
			long[] result = findAfterOperation(nums, ops, h);
			for (long num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static long[] findAfterOperation(long[] nums, int[][] ops, int h) {
		int length = nums.length;
		long[] result = new long[length];
		for (int index = 0; index < length; index++) {
			result[index] = nums[index];
		}
		Set<Integer> visitedIndex = new HashSet<>();
		List<Integer> indexList = new ArrayList<>();
		for (int[] op : ops) {
			int index = op[0];
			int val = op[1];
			index--;
			result[index] += val;
			if (!visitedIndex.contains(index)) {
				visitedIndex.add(index);
				indexList.add(index);
			}
			if (result[index] > h) {
				for (int indices : indexList) {
					result[indices] = nums[indices];
					visitedIndex.remove(indices);
				}
				indexList.clear();
			}

		}
		return result;
	}

}
