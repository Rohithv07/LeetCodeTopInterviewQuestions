/**
 * @author rohithvazhathody
 * @date 9 Jan 2026
 * Project: CodeforceContestes
 * File: Scuza.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class Scuza {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			long[] prefixSum = new long[n];
			long[] prefixMax = new long[n];
			prefixMax[0] = nums[0];
			prefixSum[0] = nums[0];
			for (int index = 1; index < n; index++) {
				prefixSum[index] = prefixSum[index - 1] + nums[index];
				prefixMax[index] = Math.max(nums[index], prefixMax[index - 1]);
			}
			for (int index = 0; index < q; index++) {
				int query = sc.nextInt();
				int maxReachingIndex = findMaxReachingIndex(prefixMax, query);
				long sum = maxReachingIndex == -1 ? 0 : (prefixSum[maxReachingIndex]);
				System.out.print(sum + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int findMaxReachingIndex(long[] prefixMax, int query) {
		int low = 0;
		int high = prefixMax.length - 1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (prefixMax[middle] <= query) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return high;
	}

}
