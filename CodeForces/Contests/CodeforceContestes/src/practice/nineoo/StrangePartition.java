package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 11-Jan-2025
 */
public class StrangePartition {

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
			long totalSum = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
				totalSum += nums[i];
			}
			long minVal = (long) Math.ceil((double) totalSum / (double) x);
			long maxVal = 0;
			for (long num : nums) {
				maxVal += Math.ceil((double) num / (double) x);
			}
			System.out.println(minVal + " " + maxVal);
		}
		sc.close();
	}

}
