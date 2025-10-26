package AdvancedAlgo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 21-Oct-2025
 */
public class DifferenceArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] nums = new int[length];
		for (int index = 0; index < length; index++) {
			nums[index] = sc.nextInt();
		}
		int left = sc.nextInt();
		int right = sc.nextInt();
		int valueToAdd = sc.nextInt();
		updateNumberAfterQueries(nums, left, right, valueToAdd);
		for (int num : nums) {
			System.out.print(num + " ");
		}
		sc.close();
	}

	private static void updateNumberAfterQueries(int[] nums, int left, int right, int valueToAdd) {
		int[] difference = new int[nums.length + 1];
		difference[0] = nums[0];
		for (int index = 1; index < nums.length; index++) {
			difference[index] = nums[index] - nums[index - 1];
		}
		difference[left] += valueToAdd;
		difference[right + 1] -= valueToAdd;
		nums[0] = difference[0];
		for (int index = 1; index < nums.length; index++) {
			nums[index] = nums[index - 1] + difference[index];
		}
	}

}
