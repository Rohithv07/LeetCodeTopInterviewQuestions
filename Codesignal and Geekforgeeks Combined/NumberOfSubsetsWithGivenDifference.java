// https://youtu.be/QihB4bI6BJw

import java.util.*;

public class NumberOfSubsetsWithGivenDifference {

	public static int findNumberOfSubset(int [] nums, int n, int diff) {
		if (n == 0 || nums == null)
			return 0;
		int sum = getSum(nums);
		int requiredSum = (sum - diff) / 2;
		// knapsack or subset sum problem
		int [][] dp = new int [n + 1][requiredSum + 1];
		for (int i=0; i<=n; i++) {
			dp[i][0] = 1;
		}
		for (int j=1; j<=requiredSum; j++) {
			dp[0][j] = 0;
		}
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=requiredSum; j++) {
				if (nums[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
				}
			}
		}
		return dp[n][requiredSum];
	}

	public static int getSum(int [] nums) {
		int sum = 0;
		for (int number : nums) {
			sum += number;
		}
		return sum;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int difference = sc.nextInt();
		System.out.println(findNumberOfSubset(nums, n, difference));
	}
}


/*

total sum, s = s1 + s2

We need to find number of subsets with s1 - s2 = diff

from equation 1: we can say s1 = s - s2
there fore
s - s2 - s2 = diff
s-2s2 = diff

(s - diff) / 2 = s2

So the problem reduces to number of subsets with a sum = s2

*/