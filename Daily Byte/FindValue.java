/*
Given a sorted integer array nums and a target, search for the target with in the array. If the targets exists within the array, return its index. If it does not exist within the array, return -1.

Ex: Given the following nums and target...

nums = [-5, -3, 0, 3, 8, 12, 40], target = 8, return 4.
Ex: Given the following nums and target...

nums = [1, 2, 3, 6, 8], target = 10, return -1.
*/

import java.util.*;

public class FindValue {

	public static int binarySearch(int [] nums, int target) {
		int length = nums.length;
		int left = 0;
		int right = length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > target) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		return -1; 
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(binarySearch(nums, target));
	}
}