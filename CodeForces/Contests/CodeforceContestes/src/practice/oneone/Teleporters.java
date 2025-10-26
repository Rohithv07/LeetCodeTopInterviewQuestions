package practice.oneone;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author rohithvazhathody 20-Oct-2025
 */
public class Teleporters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long c = sc.nextLong();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			long numberOfTelePorters = findNumberOfTeleporters(nums, c);
			System.out.println(numberOfTelePorters);
		}
		sc.close();
	}

	private static long findNumberOfTeleporters(long[] nums, long c) {
		int length = nums.length;
		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		for (int index = 0; index < length; index++) {
			minHeap.offer(nums[index] + index + 1);
		}
		long count = 0;
		while (!minHeap.isEmpty()) {
			long top = minHeap.poll();
			if (c - top < 0) {
				break;
			}
			c -= top;
			count++;
		}
		return count;
	}

}

/**
 * 4 5 4 3 2 1
 * 
 * 1 2 3 4
 * 
 * 1
 */
