/*
Given an integer array, nums, each value in the array represents a dollar amount. For every positive value you gain nums[i] dollars and for every negative value you lose nums[i] dollars. Return the minimum number of dollars you must start with such that your dollar value never becomes less than one.

Ex: Given the following nums...

nums = [1, -4, 2, -3], return 5 (5 + 1 - 4 + 2 - 3 = 1).
Ex: Given the following nums...

nums = [-10], return 11.
*/

import java.util.*;

public class SingleDollar {

	public static int dollarToMaintain1(int [] nums, int n) {
		int prefixSum = 0;
		for (int number : nums) {
			prefixSum += number;
		}
		if (prefixSum > 0) {
			return 0;
		}
		return 1 - prefixSum;
	}

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(dollarToMaintain1(nums, n));
	}
}