package practice.oneone;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Oct-2025
 */
public class SubsequenceAddition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int[] nums = new int[length];
			for (int index = 0; index < length; index++) {
				nums[index] = sc.nextInt();
			}
			String result = findIsPossible(nums);
			System.out.println(result);
		}
		sc.close();
	}

	private static String findIsPossible(int[] nums) {
		if (nums.length == 1) {
			return nums[0] == 1 ? "YES" : "NO";
		}
		Arrays.sort(nums);
		if (nums[0] != 1) {
			return "NO";
		}
		long sum = nums[0];
		for (int index = 1; index < nums.length; index++) {
			if (sum < nums[index]) {
				return "NO";
			}
			sum += nums[index];
		}
		return "YES";
	}

}
