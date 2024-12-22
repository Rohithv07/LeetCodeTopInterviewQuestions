package contests.round995;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 22-Dec-2024
 */
public class CountingPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long x = sc.nextLong();
			long y = sc.nextLong();
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextLong();
			}
			System.out.println(countPairs(n, x, y, a));
		}
		sc.close();
	}

	private static long countPairs(int n, long x, long y, long[] a) {
		Arrays.sort(a);
		long totalSum = 0;
		long[] prefixSum = new long[n];
		prefixSum[0] = a[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + a[i];
		}
		totalSum = prefixSum[n - 1];
		long lowerLimit = totalSum - y;
		long upperLimit = totalSum - x;
		long count = 0;
		for (int i = 0; i < n - 1; i++) {
			int next = i + 1;
			long howManyLeft = binarySearchLeftSide(a, next, n - 1, lowerLimit - a[i]);
			long howManyRight = binarySearchRightSide(a, next, n - 1, upperLimit - a[i]);
			count += Math.max(0, howManyRight - howManyLeft + 1);
		}

		return count;
	}
	
	// totalSum - x <= a[i] + a[j] <= totalSum - y;
	// p - a[i] <= a[j] <= p - a[i]
	// 3 4 6 6
	
//	totalSum - currentSum >= x
//	totalSum - currentSum <= y
//	totalSum - x <= currentSum >= totalSum - y

	private static long binarySearchLeftSide(long[] a, int start, int end, long l) {
		while (start <= end) {
			int middle = start + (end - start) / 2;
			if (a[middle] >= l) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return start;
	}

	private static long binarySearchRightSide(long[] a, int start, int end, long l) {
		while (start <= end) {
			int middle = start + (end - start) / 2;
			if (a[middle] <= l) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		return end;
	}

}

/**
 * 
 * 4 8 10 4 6 3 6
 * 
 * 19
 * 
 * 4 10 13 19 19 15 9 6
 * 
 * 
 */
