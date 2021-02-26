/*
Given an sorted integer array, nums, that has been rotated at an unknown index, return the minimum value.
Note: The array only contains unique values.

Ex: Given the following array nums...

nums = [7, 9, 10, 2, 4, 6], return 2.
*/

import java.util.*;

public class WhereMinimum {

	// this method will do the work in O(n)
	public static int minimum(int [] nums) {
		if (nums.length == 1)
			return nums[0];
		// already sorted or not
		// if (alreadySorted(nums))
		// 	return nums[0];
		int irregularityIndex = -1;
		for (int i=0; i<nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				irregularityIndex = i + 1;
				break;
			}
		}
		return irregularityIndex == - 1 ? nums[0] : nums[irregularityIndex];
	}

	// this method will do the work in O(logn)
	public static int binarySearchWay(int [] nums) {
		if (nums.length == 1)
			return nums[0];
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			// we can handle duplicates at this code
			if (nums[mid] == nums[right]) {
				right -= 1;
			}
			else if (nums[mid] > nums[right	]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return nums[right];
	}
	// public static boolean alreadySorted(int [] nums) {
	// 	for (int i=0; i<nums.length - 1; i++) {
	// 		if (nums[i] > nums[i + 1])
	// 			return false;
	// 	}
	// 	return true;
	// }

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(minimum(nums));
		System.out.println(binarySearchWay(nums));
	}
}