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
public class SimpleGCDProblemII {

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
		long [] store = new long [length];
		for (int index = 0; index < length; index++) {
			if (gcdTracker[index] <= nums2[index]) {
				store[index] = gcdTracker[index];
			}
			else {
				store[index] = nums1[index];
			}
		}
		for (int index = 0; index < length; index++) {
			if (nums1[index] > gcdTracker[index]) {
				if (nums2[index] >= gcdTracker[index]) {
					totalCount++;
				}
			}
			else if (nums1[index] == gcdTracker[index] && nums2[index] > nums1[index]) {
				long limit = nums2[index] / gcdTracker[index];
				long left = 1;
				long right = 1;
				if (index > 0) {
					left = store[index - 1] / findGCD(nums1[index - 1], nums1[index]);
				}
				if (index < length - 1) {
					right = store[index + 1] / findGCD(nums1[index + 1], nums1[index]); 
				}
				long best = -1;
				for (long factor = 2; factor <= limit; factor++) {
					if (isPrime(factor)) {
						if (left % factor != 0 && right % factor != 0) {
							best = factor;
							break;
						}
					}
				}
				if (best != -1) {
					totalCount++;
				}
			}
		}
		return totalCount;
	}

	private static boolean isPrime(long factor) {
		if (factor < 2) {
			return false;
		}
		if (factor <= 3) {
			return true;
		}
		if (factor % 2 == 0 || factor % 3 == 0) {
			return false;
		}
		for (long next = 4; next * next <= factor; next+=6) {
			if (factor % next == 0 || factor % (next + 2) == 0) {
				return false;
			}
		}
		return true;
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
