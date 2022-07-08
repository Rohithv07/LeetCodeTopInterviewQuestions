There is a row of m houses in a small city, each house must be painted with one of the n colors (labeled from 1 to n), some houses that have been painted last summer should not be painted again.

A neighborhood is a maximal group of continuous houses that are painted with the same color.

For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2}, {3,3}, {2}, {1,1}].
Given an array houses, an m x n matrix cost and an integer target where:

houses[i]: is the color of the house i, and 0 if the house is not painted yet.
cost[i][j]: is the cost of paint the house i with the color j + 1.
Return the minimum cost of painting all the remaining houses in such a way that there are exactly target neighborhoods. If it is not possible, return -1.

 

Example 1:

Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
Output: 9
Explanation: Paint houses of this way [1,2,2,1,1]
This array contains target = 3 neighborhoods, [{1}, {2,2}, {1,1}].
Cost of paint all houses (1 + 1 + 1 + 1 + 5) = 9.
Example 2:

Input: houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
Output: 11
Explanation: Some houses are already painted, Paint the houses of this way [2,2,1,2,2]
This array contains target = 3 neighborhoods, [{2,2}, {1}, {2,2}]. 
Cost of paint the first and last house (10 + 1) = 11.
Example 3:

Input: houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
Output: -1
Explanation: Houses are already painted with a total of 4 neighborhoods [{3},{1},{2},{3}] different of target = 3.
 

Constraints:

m == houses.length == cost.length
n == cost[i].length
1 <= m <= 100
1 <= n <= 20
1 <= target <= m
0 <= houses[i] <= n
1 <= cost[i][j] <= 104


class Solution {
    int MAX = 100000000;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                Arrays.fill(dp[i][j], -1);
        }

        int ans = paintRecursively(houses, cost, m, n, target, 0, 0, -1, dp);
        if (ans == MAX) {
            return -1;
        }
        return ans;
    }

    //houseToBePainted = current house to be painted
    //currentTarget = number of neighborhoods painted till now
    //lastNbhColor = last neighbours color
    public int paintRecursively(int[] houses, int[][] cost, int m, int n, int target,
                                int houseToBePainted, // Dp state
                                int currentTarget, // Dp state
                                int lastNbhColor, // Dp state
                                int[][][] dp
    ) {
        if (houseToBePainted == m) {
            if (currentTarget == target) return 0;
            return MAX;
        }
        if (currentTarget == target + 1) return MAX;
        if (lastNbhColor != -1) {
            if (dp[houseToBePainted][lastNbhColor][currentTarget] != -1) {
                return dp[houseToBePainted][lastNbhColor][currentTarget];
            }
        }
        int minCost = MAX;
        //Step 1: Choose a paint color
        for (int currentColor = 0; currentColor < n; ++currentColor) {
            // Do we even need to paint? Or the house is already painted with color that we chose.
            boolean isFree = false;
            if (houses[houseToBePainted] != 0) {
                //Note: If house is already painted with a different color than the one which we are using, stop right away, since we cannot override a paint.
                if (houses[houseToBePainted] != currentColor + 1)
                    continue;
                else // No need to pay to paint this color, it's already painted!
                    isFree = true;
            }
            //Step 2: Are we using a new paint that was not same as the last one?
            //Step 2A: If yes, we will create a new neighborhood from here 
            if (currentColor != lastNbhColor) {
                minCost = Math.min(minCost, paintRecursively(houses, cost, m, n, target, houseToBePainted + 1, currentTarget + 1, currentColor, dp) + ((isFree) ? 0 : cost[houseToBePainted][currentColor]));

            } else { // Step2B: If no, we will continue with previous neighborhood 
                minCost = Math.min(minCost, paintRecursively(houses, cost, m, n, target, houseToBePainted + 1, currentTarget, currentColor, dp) + ((isFree) ? 0 : cost[houseToBePainted][currentColor]));
            }
        }
        if (lastNbhColor != -1) {
            dp[houseToBePainted][lastNbhColor][currentTarget] = minCost;
        }
        return minCost;
    }

}