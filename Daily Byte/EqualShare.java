/*
Given an integer array, nums, which contains only positive integers, return whether or not nums can be partitioned into two separate subsets such that the sum of the two subsets are equal.

Ex: Given the following nums…

nums = [1, 1, 2], return true.
Ex: Given the following nums…

nums = [10, 3, 2], return false.
*/

import java.util.*;

public class EqualShare {

	public static boolean canWeEquallyPartition(int [] nums, int n) {
		// total sum
		int sum = 0;
		for (int number : nums)
			sum += number;
		if (sum % 2 != 0)
			return false;
		// knapsack code
		boolean [][] dp = new boolean[n + 1][sum/2 + 1];
		for (int i=0; i<=n; i++) {
			for (int j=0; j<=sum/2; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = false;
				else if (nums[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else if (nums[i-1] == j)
					dp[i][j] = true;
				else
					dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
			}
		}
		return dp[n][sum/2];
	}	
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(canWeEquallyPartition(nums, n));
	}	
}

