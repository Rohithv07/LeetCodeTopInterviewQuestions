
// https://atcoder.jp/contests/dp/tasks/dp_b

// https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5


// this is just a follow up to the frog jump problem where 
// in that problem only 1 step or 2 step was allowed
// here it can be 1, 2, 3, .... k steps

// TC - O(N) SC - O(N) + O(Stack Space) - Memoization

// TC - O(N) SC - O(N) - Tabulation


import java.util.*;

public class FrogJumpsWithKDistance {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] height = new int [n];
		for (int i = 0; i < n; i++) {
			height[i] = sc.nextInt();
		}
		int [] dp = new int [n];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = Math.abs(height[1] - height[0]);
		for (int i = 2; i < n; i++) {
			int minimum = Integer.MAX_VALUE;
			for (int j = 1; j <= k; j++) {
				if (i - j >= 0) {
					int value = dp[i - j] + Math.abs(height[i] - height[i - j]);
					minimum = Math.min(minimum, value);
				}
				else {
					break;
				}
			}
			dp[i] = minimum;
		}
		System.out.println(dp[n - 1]);
		//System.out.println(findMinimumJump(n - 1, k, height, dp));
	}

	private static int findMinimumJump(int n, int k, int [] height, int [] dp) {
		if (n <= 1) {
			return dp[n];
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		int minimum = Integer.MAX_VALUE;
		for (int i = 1; i <= k; i++) {
			if (n - i >= 0) {
				int value = findMinimumJump(n - i, k, height, dp) + Math.abs(height[n] - height[n - i]);
				minimum = Math.min(minimum, value);
			}
			else {
				break;
			}
			
		}
		return dp[n] = minimum;
	}



}