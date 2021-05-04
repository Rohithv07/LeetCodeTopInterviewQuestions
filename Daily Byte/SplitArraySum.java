/*
Given an integer array, nums, return whether or not you can split the array into three subarrays all of which have an equal sum.

Ex: Given the following nums…

nums = [2, 3, 9, 9, 3, 2, 3, 2, 9], return true.
Ex: Given the following nums…

nums = [1, 2, 3], return false.
*/

import java.util.*;

public class SplitArraySum {

	public static boolean canWeSplit(int [] nums, int n) {
		if (n <= 2)
			return false;
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}
		if (totalSum % 3 != 0)
   			return false;
		int index1 = -1;
		int index2 = -1;
		int firstPartSum = totalSum / 3;
		// totalSum = s / 3 + s / 3 + s / 3 = (2s) / 3 + s / 3
		int remainingPartSum = (2 * totalSum) / 3;
		int prefixSum = 0;
		for (int i=0; i<n; i++) {
			prefixSum += nums[i];
			if (prefixSum == firstPartSum && index1 == -1) {
				index1 = i;
			}
			else if (prefixSum == remainingPartSum && index1 != -1) {
				index2 = i;
				break;
			}
		}
		if (index1 == -1 || index2 == -1)
			return false;
		System.out.print(index1 + " " + index2);
		return true;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(canWeSplit(nums, n));
	}
}
