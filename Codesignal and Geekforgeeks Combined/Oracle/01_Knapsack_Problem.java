You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here 
         if (w <= 0 || wt == null || wt.length == 0 || val == null || val.length == 0 || n == 0) {
             return 0;
         }
         int [][] dp = new int [n + 1][w + 1];
         for (int i=0; i<=n; i++) {
             for (int j=0; j<=w; j++) {
                 if (i == 0 || j == 0) {
                     dp[i][j] = 0;
                 }
                 else if (wt[i - 1] > j) {
                     dp[i][j] = dp[i - 1][j];
                 }
                 else {
                     dp[i][j] = Math.max(dp[i - 1][j] , val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                 }
             }
         }
         return dp[n][w];
    } 
}


// recursion

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here 
         if (w <= 0 || wt == null || wt.length == 0 || val == null || val.length == 0 || n == 0) {
             return 0;
         }
         Integer [][] dp = new Integer[n + 1][w + 1];
         return maxPossibleWeight(dp, w, wt, val, n);
    } 
    
    static int maxPossibleWeight(Integer [][] dp, int w, int [] wt, int [] val, int n) {
        if (n == 0 || w == 0)
            return 0;
        if (dp[n - 1][w - 1] != null) {
            return dp[n - 1][w - 1];
        }
        if (wt[n - 1] > w) {
            return maxPossibleWeight(dp, w, wt, val, n-1);
        }
        return dp[n - 1][w - 1] = Math.max(maxPossibleWeight(dp, w, wt, val, n-1), val[n - 1] + maxPossibleWeight(dp, w - wt[n - 1], wt, val, n - 1));
    }
}


