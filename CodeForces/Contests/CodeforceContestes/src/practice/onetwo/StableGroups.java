/**
 * @author rohithvazhathody
 * @date 15 Feb 2026
 * Project: CodeforceContestes
 * File: StableGroups.java
 */

package practice.onetwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class StableGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();
		long x = sc.nextLong();
		long[] nums = new long[n];
		for (int index = 0; index < n; index++) {
			nums[index] = sc.nextLong();
		}
		long minStableGroups = findMinStableGroups(nums, k, x);
		System.out.println(minStableGroups);
		sc.close();
	}

	private static long findMinStableGroups(long[] nums, long k, long x) {
		int length = nums.length;
		Arrays.sort(nums);
		int groups = 1;
		List<Long> differences = new ArrayList<>();
		for (int index = 1; index < length; index++) {
			if (nums[index] - nums[index - 1] > x) {
				groups++;
				differences.add(nums[index] - nums[index - 1]);
			}
		}
		if (k == 0) {
			return groups;
		}
		Collections.sort(differences);
		for (long difference : differences) {
			long val = (difference / x) + (difference % x != 0 ? 1 : 0) - 1;
			if (k >= val) {
				k -= val;
				groups--;
			}
		}
		return groups;
	}

}

/*
 * 
 * 1 1 5 8 12 13 20 22
 * 
 * 1 - 1 = 0 5 - 1 = 4 8 - 5 = 3 12 - 8 = 4 13 - 12 = 1 20 - 13 = 7 22 - 20 = 2
 * 
 * 
 * 20 20 80 70 70 70 420 5 1 5 1 60 90
 * 
 * 1 1 5 5 20 20 60 70 70 70 80 90 420
 * 
 * 1 - 1 = 0 5 - 1 = 4 5 - 5 = 0 20 - 5 = 15 20 - 20 = 0 60 - 20 = 40 70 - 60 =
 * 10 70 - 70 = 0 70 - 70 = 0 80 - 70 = 10 90 - 80 = 10 420
 * 
 * 10 4 1 10 1 6 10 1 1 6 8 6 8
 * 
 * 1 1 1 6 6 6 8 8 10 10
 * 
 * 2
 * 
 * 1 - 1 = 0 1 - 1 = 0 6 - 1 = 5 6 - 6 = 0 6 - 6 = 0 8 - 6 = 2 8 - 8 = 0 10- 8 =
 * 2 10 - 10 = 0
 * 
 *
 * 
 */
