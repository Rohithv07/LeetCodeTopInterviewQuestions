/*
Given an integer array, nums, return the maximum sum that exists between two elements that is less than k.

Ex: Given the following nums…

nums = [8, 2, 4, 9], k = 13, return 12 (8 + 12 = 12 < 13).
Ex: Given the following nums…

nums = [19, 10, 14, 23, 12], k = 39, return 37.
*/

import java.util.*;

public class MaxSumLessThanK {

	public static int[] getMaxSumLessThanK(int [] nums, int n, int k) {
		if (n == 1 && nums[0] < k)
			return new int [] {0, 0, nums[0]};
		Arrays.sort(nums);
		int left = 0;
		int right = n - 1;
		int sum = Integer.MIN_VALUE;
		while (left < right) {
			if (nums[left] + nums[right] < k) {
				sum = Math.max(sum, nums[left] + nums[right]);
				left += 1;
			}
			else {
				right -= 1;
			}
		}
		return new int [] {left - 1, right, sum}; // here the index are shown after sorting.
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int [] result = getMaxSumLessThanK(nums, n, k);
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}