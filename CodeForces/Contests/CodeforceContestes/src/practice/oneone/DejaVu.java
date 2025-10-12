package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 27-Sept-2025
 */
public class DejaVu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int query = sc.nextInt();
			long[] nums = new long[length];
			long[] modification = new long[query];
			for (int index = 0; index < length; index++) {
				nums[index] = sc.nextLong();
			}
			for (int index = 0; index < query; index++) {
				modification[index] = sc.nextLong();
			}
			long[] modified = findModified(nums, modification);
			for (long mod : modified) {
				System.out.print(mod + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static long[] findModified(long[] nums, long[] modification) {
		long smallest = 31;
		for (int index1 = 0; index1 < modification.length; index1++) {
			long xi = modification[index1];
			if (xi >= smallest) {
				continue;
			}
			long result = (long) (Math.pow(2, xi));
			long diff = (long) (Math.pow(2, xi - 1));
			for (int index2 = 0; index2 < nums.length; index2++) {
				long currentNum = nums[index2];
				if (currentNum % result == 0) {
					nums[index2] += diff;
				}
			}
			smallest = xi;
		}
		return nums;
	}

}
