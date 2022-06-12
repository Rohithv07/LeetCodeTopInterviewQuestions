
// https://practice.geeksforgeeks.org/contest/interview-series-54/problems/

class Solution {
    public static boolean makeChanges(int n, int k, int target, int[] coins) {
        // code here
        Boolean [][] dp = new Boolean [k + 1][target + 1]; // will be null initial
        return isPossible(n, k, target, coins, dp);
    }
    
    private static boolean isPossible(int n, int k, int target, int [] coins, Boolean [][] dp) {
        if (k == 0 && target == 0) {
            return true;
        }
        if (k <= 0 || target <= 0) {
            return false;
        }
        if (dp[k][target] != null) {
            return dp[k][target];
        }
        boolean result = false;
        for (int i = 0; i < n; i++) {
            result = result | isPossible(n, k - 1, target - coins[i], coins, dp);
        }
        return dp[k][target] = result;
    }
}
