package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 27-Sept-2025
 */
public class BuildingAnAquarium {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int water = sc.nextInt();
			long[] nums = new long[length];
			for (int index = 0; index < length; index++) {
				nums[index] = sc.nextLong();
			}
			System.out.println(findMaxHeight(nums, water));
		}
		sc.close();
	}

	private static long findMaxHeight(long[] nums, int water) {
		long low = 0;
		long high = (long) (1e12);
		long answer = -1;
		while (low <= high) {
			long middle = low + (high - low) / 2;
			if (isUnitAllocated(nums, water, middle)) {
				answer = middle;
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return answer;
	}

	private static boolean isUnitAllocated(long[] nums, int water, long middle) {
		long currentWater = 0;
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] <= middle) {
				currentWater += middle - nums[index];
			}
		}
		return currentWater <= water;
	}

}
