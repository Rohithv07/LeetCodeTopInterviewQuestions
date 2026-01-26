/**
 * @author rohithvazhathody
 * @date 25 Jan 2026
 * Project: CodeforceContestes
 * File: ReversePermutation.java
 */

package contests.round1076;

import java.util.Scanner;

/**
 * 
 */
public class ReversePermutation {

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
			int[] largest = findLargest(nums);
			for (int num : largest) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int[] findLargest(int[] nums) {
		int length = nums.length;
		// if already sorted
		boolean isAlreadySorted = true;
		for (int index = 0; index + 1 < length; index++) {
			if (nums[index] < nums[index + 1]) {
				isAlreadySorted = false;
				break;
			}
		}
		if (isAlreadySorted) {
			return nums;
		}
		int largestNum = length;
		int index = 0;
		while (index < length && nums[index] == largestNum) {
			index++;
			largestNum--;
		}
		int breakingIndex = index;
		int nextIndex = breakingIndex;
		for (nextIndex = breakingIndex; nextIndex < length; nextIndex++) {
			if (nums[nextIndex] == largestNum) {
				break;
			}
		}
		swap(nums, breakingIndex, nextIndex);
		return nums;
	}

	private static void swap(int[] nums, int breakingIndex, int nextIndex) {
		while (breakingIndex < nextIndex) {
			int temp = nums[breakingIndex];
			nums[breakingIndex] = nums[nextIndex];
			nums[nextIndex] = temp;
			breakingIndex++;
			nextIndex--;
		}

	}

}
