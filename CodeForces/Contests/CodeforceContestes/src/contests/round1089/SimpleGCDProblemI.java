/**
 * @author rohithvazhathody
 * @date 29 Mar 2026
 * Project: CodeforceContestes
 * File: SimpleGCDProblemI.java
 */

package contests.round1089;

import java.util.Scanner;

/**
 * 
 */
public class SimpleGCDProblemI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums1 = new long[n];
			long[] nums2 = new long[n];
			for (int index = 0; index < n; index++) {
				nums1[index] = sc.nextLong();
			}
			for (int index = 0; index < n; index++) {
				nums2[index] = sc.nextLong();
			}
			long maxOperation = findMaxOperation(nums1, nums2);
			System.out.println(maxOperation);
		}
		sc.close();
	}

	private static long findMaxOperation(long[] nums1, long[] nums2) {
		int length = nums1.length;
		long[] gcdTracker = new long[length];
		gcdTracker[0] = findGCD(nums1[0], nums1[1]);
		long totalCount = 0;
		gcdTracker[length - 1] = findGCD(nums1[length - 1], nums1[length - 2]);
		for (int index = 1; index + 1 < length; index++) {
			long previousNum = nums1[index - 1];
			long currentNum = nums1[index];
			long nextNum = nums1[index + 1];
			long currentGCDPrevious = findGCD(previousNum, currentNum);
			long currentGCDNext = findGCD(currentNum, nextNum);
			long lcm = findLCM(currentGCDPrevious, currentGCDNext);
			gcdTracker[index] = lcm;
		}
		for (int index = 0; index < length; index++) {
			if (nums1[index] > gcdTracker[index]) {
				totalCount++;
			}
		}
		return totalCount;
	}

	private static long findLCM(long currentGCDPrevious, long currentGCDNext) {
		if (currentGCDPrevious == 0 || currentGCDNext == 0) {
			return 0;
		}
		return (currentGCDPrevious / findGCD(currentGCDPrevious, currentGCDNext)) * currentGCDNext;
	}

	private static long findGCD(long currentNum, long nextNum) {
		if (nextNum == 0) {
			return currentNum;
		}
		return findGCD(nextNum, currentNum % nextNum);
	}

}
