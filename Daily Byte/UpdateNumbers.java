/*
Given an array of integers, nums, return the minimum number of operations needed to make every value in nums unique.
Note: An operation consists of selecting a value in nums and incrementing it by one.

Ex: Given the following nums…

nums = [2, 2, 1, 3], return 2 (increment one of the twos twice or increment one 2 once and the 3 once).
Ex: Given the following nums…

nums = [4, 1, 2], return 0 (no operations are needed).
*/

import java.util.*;

public class UpdateNumbers {

	public static int minOperationToMakeUnique(int [] nums, int n) {
		if (nums == null || n == 0)
			return 0;
		Arrays.sort(nums);
		int moves = 0;
		int previous = nums[0];
		for (int i=1; i<nums.length; i++) {
			previous = Math.max(previous + 1, nums[i]);
			moves += previous - nums[i];
		}
		return moves;
		
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(minOperationToMakeUnique(nums, n));
	}
}