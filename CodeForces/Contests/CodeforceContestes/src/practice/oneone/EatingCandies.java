package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 25-Oct-2025
 */
public class EatingCandies {

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
			int maxCandies = findMaxCandies(nums);
			System.out.println(maxCandies);
		}
		sc.close();
	}

	private static int findMaxCandies(int[] nums) {
		int prefixSum = 0;
		int suffixSum = 0;
		int maxCandies = 0;
		int length = nums.length;
		int left = 0;
		int right = length - 1;
		boolean isLeft = true;
		boolean isRight = true;
		while (left < right) {
			int leftMost = nums[left];
			int rightMost = nums[right];
			if (isLeft) {
				prefixSum += leftMost;
			}
			if (isRight) {
				suffixSum += rightMost;
			}
			if (prefixSum == suffixSum) {
				maxCandies = (left + 1 + length - right);
				left++;
				right--;
				isLeft = true;
				isRight = true;
			}
			else if (prefixSum > suffixSum) {
				right--;
				isLeft = false;
				isRight = true;
			}
			else {
				left++;
				isLeft = true;
				isRight = false;
			}
		}
		return maxCandies;
	}

}

/**
 * 2 1 4 2 4 1
 * 
 * 2 3 7 9 13 14 14 12 11 7 5 1
 */