/*
Given a sorted array of integers, nums, and a target, return the index of the target within nums. If it does not exist, return the index of where target should be inserted.

Ex: Given the following nums and target...

nums = [1, 5, 8, 12], target = 12, return 3.
Ex: Given the following nums and target...

nums = [3, 4, 7, 12, 29], target = 5, return 2.
*/


import java.util.*;

public class InsertValue {

	public static int findElseInsert(int [] nums, int pos) {
		int length = nums.length;
		int left = 0;
		int right = length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == pos) {
				return mid;
			}
			else if (nums[mid] > pos) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int pos = sc.nextInt();
		System.out.println(findElseInsert(nums, pos));
	}
}