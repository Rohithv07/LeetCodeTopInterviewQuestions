/*
Given an integer array, nums, return the length of the longest increasing subarray.
Note: The subarray must be strictly increasing.

Ex: Given the following nums.

nums = [1, 2, 3], return 3.
Ex: Given the following nums.

nums = [3, 4, 1, 2, 8], return 3.
*/

import java.util.*;

public class LengthOfIncrease {

	public static int longestIncreasingSubArray(int [] nums) {
		if (nums.length == 0)
			return 0;
		int result = 0;
		int current = 1;
		for (int i=1; i<nums.length; i++) {
			if (nums[i] > nums[i - 1])
				current += 1;
			else {
				result = Math.max(result, current);
				current = 1;
			}
		}
		return Math.max(result, current);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(longestIncreasingSubArray(nums));
	}
}
