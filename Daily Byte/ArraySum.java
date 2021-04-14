/*
Given an integer array, nums, return an array containing its running sum at every index.

Ex: Given the following nums…

nums = [1, 2, 3], return [1, 3, 6].
Ex: Given the following nums…

nums = [10], return [10].
*/

import java.util.*;

public class ArraySum {

	public static int [] findRunningSum(int [] nums, int n) {
		if (n == 1)
			return new int [] {nums[0]};
		int [] result = new int [n];
		result[0] = nums[0];
		for (int i=1; i<n; i++) {
			result[i] = result[i-1] + nums[i];
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int [] result = findRunningSum(nums, n);
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}
