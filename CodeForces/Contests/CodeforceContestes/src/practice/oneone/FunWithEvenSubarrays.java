package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 26-Oct-2025
 */
public class FunWithEvenSubarrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			int minOperation = findMinOperation(nums);
			System.out.println(minOperation);
		}
		sc.close();
	}

	private static int findMinOperation(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		int right = nums.length - 1;
		int operation = 0;
		while (right >= 0 && nums[right] == nums[nums.length - 1]) {
			right--;
		}
		if (right == -1) {
			return 0;
		}
		while (right >= 0) {
			right -= (nums.length - right - 1);
			operation++;
			while (right >= 0 && nums[right] == nums[nums.length - 1]) {
				right--;
			}
		}
		return operation;
	}

}
