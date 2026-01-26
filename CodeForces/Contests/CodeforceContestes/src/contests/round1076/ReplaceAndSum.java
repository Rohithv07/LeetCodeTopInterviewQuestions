/**
 * @author rohithvazhathody
 * @date 25 Jan 2026
 * Project: CodeforceContestes
 * File: ReplaceAndSum.java
 */

package contests.round1076;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class ReplaceAndSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			int[] nums1 = new int[n];
			int[] nums2 = new int[n];
			for (int index = 0; index < n; index++) {
				nums1[index] = sc.nextInt();
			}
			for (int index = 0; index < n; index++) {
				nums2[index] = sc.nextInt();
			}
			int[][] query = new int[q][2];
			for (int index = 0; index < q; index++) {
				query[index][0] = sc.nextInt();
				query[index][1] = sc.nextInt();
			}
			List<Integer> result = findQueryResult(nums1, nums2, query);
			for (Integer num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static List<Integer> findQueryResult(int[] nums1, int[] nums2, int[][] query) {
		int length = nums1.length;
		int[] prefixSum = new int[length];
		int[] prefixMax1 = new int[length];
		int[] prefixMax2 = new int[length];
		int[] base = new int[length];
		int[] suffixMax = new int[length];
		base[0] = Math.max(nums1[0], nums2[0]);
		prefixMax1[0] = nums1[0];
		prefixMax2[0] = nums2[0];
		prefixSum[0] = nums1[0];
		List<Integer> result = new ArrayList<>();
		for (int index = 1; index < length; index++) {
			prefixSum[index] = prefixSum[index - 1] + nums1[index];
			prefixMax1[index] = Math.max(nums1[index], prefixMax1[index - 1]);
			prefixMax2[index] = Math.max(nums2[index], prefixMax2[index - 1]);
			base[index] = Math.max(nums1[index], nums2[index]);
		}
		suffixMax[length - 1] = base[length - 1];
		for (int index = length - 2; index >= 0; index--) {
			suffixMax[index] = Math.max(base[index], suffixMax[index + 1]);
		}
		prefixSum[0] = suffixMax[0];
		for (int index = 1; index < length; index++) {
			prefixSum[index] = prefixSum[index - 1] + suffixMax[index];

		}
		for (int[] q : query) {
			int l = q[0] - 1;
			int r = q[1] - 1;
			int sum = 0;
			if (l == 0) {
				sum = prefixSum[r];
			} else {
				sum = prefixSum[r] - prefixSum[l - 1];
			}
			result.add(sum);
		}
		return result;
	}

}

/*
 * 3 2 1 1 2 3
 * 
 * 0 2 3 5 6
 * 
 * 
 * 2 - 0 + 1 * maxOfAll =
 * 
 * 
 * 
 */
