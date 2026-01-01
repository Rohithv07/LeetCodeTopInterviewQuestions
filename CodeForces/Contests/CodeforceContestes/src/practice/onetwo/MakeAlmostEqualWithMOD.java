package practice.onetwo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody 09-Dec-2025
 */
public class MakeAlmostEqualWithMOD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			System.out.println(findKValue(nums));
		}
		sc.close();
	}

	private static long findKValue(long[] nums) {
		for (int num = 1; num <= 60; num++) {
			Set<Long> distinct = new HashSet<>();
			long k = 1L << num;
			for (int index = 0; index < nums.length; index++) {
				distinct.add(nums[index] % k);
				if (distinct.size() > 2) {
					break;
				}
			}
			if (distinct.size() == 2) {
				return k;
			}
		}
		return -1;
	}

}
