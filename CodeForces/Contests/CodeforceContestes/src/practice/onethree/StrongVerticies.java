/**
 * @author rohithvazhathody
 * @date 27 Feb 2026
 * Project: CodeforceContestes
 * File: StrongVerticies.java
 */

package practice.onethree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class StrongVerticies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums1 = new long[n + 1];
			long[] nums2 = new long[n + 1];
			for (int index = 1; index <= n; index++) {
				nums1[index] = sc.nextLong();
			}
			for (int index = 1; index <= n; index++) {
				nums2[index] = sc.nextLong();
			}
			List<Long> maxes = findMaxes(nums1, nums2);
			System.out.println(maxes.size());
			for (Long val : maxes) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static List<Long> findMaxes(long[] nums1, long[] nums2) {
		int length = nums1.length;
		List<Long> result = new ArrayList<>();
		long max = Long.MIN_VALUE;
		for (int index = 1; index < length; index++) {
			max = Math.max(max, nums1[index] - nums2[index]);
		}
		for (int index = 1; index < length; index++) {
			if (nums1[index] - nums2[index] == max) {
				result.add((long) index);
			}
		}
		return result;
	}

}

/*
 * 
 * 
 * 
 * au - av >= bu - bv
 * 
 * 
 * 
 */
