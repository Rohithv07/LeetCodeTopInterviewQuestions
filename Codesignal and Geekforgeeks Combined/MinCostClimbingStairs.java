Given an array of integers cost[] of length N, where cost[i] is the cost of the ith step on a staircase. Once the cost is paid, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.

Example 1:

Input:
N = 3
cost[] = {10, 15, 20}
Output:
15
Explanation:
Cheapest option is to start at cost[1],
pay that cost, and go to the top.

Example 2:

Input:
N = 10
arr[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
Output:
6
Explanation:
Cheapest option is to start on cost[0], 
and only step on 1s, skipping cost[3].

Your Task:
The task is to complete the function minCostClimbingStairs() which takes an array cost[] as input and returns the minimum cost to reach the top.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
2 ≤ N ≤ 103
0 ≤ cost[i] ≤ 999


class Solution {
    static int minCostClimbingStairs(int[] cost , int n) {
        //Write your code here
        if (cost == null || n == 0)
            return 0;
        int [] dp = new int [n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i<n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}