/*
Given an array of integers, nums, and a value k, return the maximum average value from any contiguous subarray of size k in nums.

Ex: Given the following nums and k…

nums = [4, -1, 4, 2], k = 2, return 3.0 ((4 + 2) / 2 = 3.0).
Ex: Given the following nums and k…

nums = [5, 1, -3, 5, 2], k = 3, return 1.33.
*/

// ref : https://www.geeksforgeeks.org/find-maximum-average-subarray-of-k-length/

import java.util.*;

public class MaxAverageSubArray {

	public static double getMaxAverageSubArray(int [] nums, int n, int k) {
		if (k > n)
			return 0.0;
		// calculate cumulative sum upto k, and let it be the max we have.
		// continue finding the sum from k to n - 1 and check the with the max we have
		// finally divide by k to get the answer
		int sum = 0;
		for (int i=0; i<k; i++) {
			sum += nums[i];
		}
		int maxSum = sum;
		for (int i=k; i<n; i++) {
			sum = sum + nums[i] - nums[i - k];
			maxSum = Math.max(sum, maxSum);
		}
		return (double)((double) maxSum / (double) k);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(getMaxAverageSubArray(nums, n, k));
	}
}
