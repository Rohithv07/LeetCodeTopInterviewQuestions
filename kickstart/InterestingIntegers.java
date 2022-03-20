


// Test cases 1 passed, Test cases 2 TLE

/**
 * 
 */

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			long n1 = sc.nextLong();
			long n2 = sc.nextLong();
			System.out.println("Case #" + t + ": " + findTheInterestingNumber(n1, n2));
		}
	}

	private static long findTheInterestingNumber(long n1, long n2) {
		// TODO Auto-generated method stub
		long count = 0;
		for (long i = n1; i <= n2; i++) {
			long[] productAndSum = findSumAndProduct(i);
			long product = productAndSum[0];
			long sum = productAndSum[1];
			if (product % sum == 0) {
				count++;
			}
		}
		return count;
	}

	private static long[] findSumAndProduct(long n1) {
		long digitSum1 = 0;
		long digitProduct1 = 1;
		while (n1 > 0) {
			long rem = n1 % 10;
			digitSum1 += rem;
			digitProduct1 *= rem;
			n1 /= 10;
		}
		return new long[] { digitProduct1, digitSum1 };
	}

}
