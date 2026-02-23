/**
 * @author rohithvazhathody
 * @date 15 Feb 2026
 * Project: CodeforceContestes
 * File: PleasantPairs.java
 */

package practice.onetwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class PleasantPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			long[] nums = new long[length];
			for (int index = 0; index < length; index++) {
				nums[index] = sc.nextLong();
			}
			long totalPairs = findPairs(nums);
			System.out.println(totalPairs);
		}
		sc.close();
	}

	private static long findPairs(long[] nums) {
		int length = nums.length;
		Pair[] pair = new Pair[length];
		for (int index = 0; index < length; index++) {
			pair[index] = new Pair(nums[index], index);
		}
		Arrays.sort(pair, (p1, p2) -> Long.compare(p1.val, p2.val));
		long count = 0;
		for (int index1 = 0; index1 < length; index1++) {
			for (int index2 = index1 + 1; index2 < length; index2++) {
				if (pair[index1].val * pair[index2].val > 2 * length) {
					break;
				}
				if (pair[index1].val * pair[index2].val == pair[index1].index + pair[index2].index + 2) {
					count++;
				}
			}
		}
		return count;
	}

	static class Pair {
		long val;
		int index;

		public Pair(long val, int index) {
			this.val = val;
			this.index = index;
		}
	}

}

/*
 * 
 * 
 * a1, a2 ... an
 * 
 * (i, j) i < j
 * 
 * ai * aj = i + j
 * 
 * ai = ((i + j) / aj)
 * 
 * 
 * 3 1 5 9 2 1 2 3 4 5
 * 
 * 6 => 6 3 => 3 * 1 2 + 3 = 5 = 1 * 5
 * 
 * 
 * 
 */