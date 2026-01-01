package practice.onetwo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 01-Jan-2026
 */
public class PlusMinusPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long x = sc.nextLong();
			long y = sc.nextLong();
			long maxSum = findMaxSum(n, x, y);
			System.out.println(maxSum);
		}
		sc.close();
	}

	private static long findMaxSum(long n, long x, long y) {
		if (x == y) {
			return 0;
		}
		long totalXDivisor = n / x;
		long totalYDivisor = n / y;
		long lcmXY = findLCM(x, y);
		long excludedYFromX = totalXDivisor - (n / lcmXY);
		long excludedXFromY = totalYDivisor - (n / lcmXY);
		long totalXSum = (excludedYFromX * (n + n - excludedYFromX + 1)) / 2;
		long totalYSum = (excludedXFromY * (1 + excludedXFromY)) / 2;
		return totalXSum - totalYSum;
	}

	private static long findLCM(long x, long y) {
		return (x * y) / (findGCD(x, y));
	}

	private static long findGCD(long a, long b) {
		if (b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}

}
