/**
 * @author rohithvazhathody
 * @date 12 Feb 2026
 * Project: CodeforceContestes
 * File: DolceVita.java
 */

package practice.onetwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class DolceVita {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long x = sc.nextLong();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			long totalPacket = findTotalPacket(nums, x);
			System.out.println(totalPacket);
		}
		sc.close();
	}

	private static long findTotalPacket(long[] nums, long x) {
		int length = nums.length;
		Arrays.sort(nums);
		long[] prefixSum = new long[length];
		prefixSum[0] = nums[0];
		long totalPacket = 0;
		for (int index = 1; index < length; index++) {
			prefixSum[index] = prefixSum[index - 1] + nums[index];
		}
		for (int index = 0; index < length; index++) {
			totalPacket += findPacketCount(prefixSum[index], index, x);
		}
		return totalPacket;
	}

	private static long findPacketCount(long val, int index, long x) {
		long low = 1;
		long high = (int) (1e9);
		long packets = 0;
		while (low <= high) {
			long middle = low + (high - low) / 2;
			if (canBuyPacket(middle, val, index, x)) {
				packets = middle;
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return packets;
	}

	private static boolean canBuyPacket(long middle, long val, int index, long x) {
		return val + (1L * (index + 1) * (middle - 1)) <= x;
	}

}
