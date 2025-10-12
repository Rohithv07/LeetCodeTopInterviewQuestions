package practice.oneone;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 29-Sept-2025
 */
public class CountingOrders {

	/**
	 * @param args
	 * 
	 */

	private static final int MOD = (int) (1e9 + 7);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int[] nums1 = new int[length];
			int[] nums2 = new int[length];
			for (int index = 0; index < length; index++) {
				nums1[index] = sc.nextInt();
			}
			for (int index = 0; index < length; index++) {
				nums2[index] = sc.nextInt();
			}
			long totalWays = findTotalWays(nums1, nums2);
			System.out.println(totalWays);
		}
		sc.close();
	}

	private static long findTotalWays(int[] nums1, int[] nums2) {
		int length = nums1.length;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		long totalCount = 1;
		for (int index = length - 1; index >= 0; index--) {
			int currentNum = nums2[index];
			int largestLesserIndex = findLargestLesser(currentNum, nums1, length);
			int alreadyPlaced = length - index - 1;
			int choices = largestLesserIndex - alreadyPlaced;
			if (choices <= 0) {
				return 0;
			}
			totalCount = (totalCount * choices) % MOD;
		}
		return totalCount;
	}

	private static int findLargestLesser(int currentNum, int[] nums1, int length) {
		int left = 0;
		int right = length - 1;
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (nums1[middle] <= currentNum) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return nums1.length - left;
	}

}
