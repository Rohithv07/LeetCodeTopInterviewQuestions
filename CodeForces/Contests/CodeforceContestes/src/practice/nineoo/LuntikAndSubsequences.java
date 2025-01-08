package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Jan-2025
 */
public class LuntikAndSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			System.out.println(numberOfSubseq(nums, n));
		}
		sc.close();
	}

	private static long numberOfSubseq(long[] nums, int n) {
		long countOne = 0;
		long countZero = 0;
		for (long num : nums) {
			if (num == 0) {
				countZero++;
			} else if (num == 1) {
				countOne++;
			}
		}
		return countOne * (long) (Math.pow(2, countZero));
	}

}

/**
 * 
 * 1 2 3 4 5 1 3 6 10 15 15 14 12 9 5
 * 
 * 
 * 3 0 2 1 1 3 3 5 6 7 7 4 4 2 1
 * 
 * 3 -> 7 - 3 = 4 3 -> 7 - 3 = 4 5 -> 7 - 5 = 2 6 -> 7 - 6 = 1
 * 
 * 
 * 1 4 -> 1 2 -> 1 5 -> 1 1
 * 
 */
