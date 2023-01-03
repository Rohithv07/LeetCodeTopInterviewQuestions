Given a list intervals of n intervals, the ith element [s, e, p] denotes the starting point s, ending point e, and the profit p earned by choosing the ith interval. Find the maximum profit one can achieve by choosing a subset of non-overlapping intervals.

Two intervals [s1, e1, p1] and [s2, e2, p2] are said to be non-overlapping if [e1 <= s2] and [s1 < s2].

Example 1:

Input:
n = 3
intervals = {
{1, 2, 4},
{1, 5, 7},
{2, 4, 4}
}
Output:
8
Explanation:
One can choose intervals [1, 2, 4] and [2, 4, 4] for a 
profit of 8.
Example 2:

Input:
n = 3
intervals = {
{1, 4, 4},
{2, 3, 7},
{2, 3, 4}
}
Output:
7
Explanation:
One can choose interval [2, 3, 7] for a profit of 7.
Your Task:

You don't need to print or output anything. Complete the function maximum_profit() which takes an integer n and a 2D integer array intervals and returns an integer, denoting the maximum profit which one can get by choosing the non-overlapping intervals.

Constraints:

1 <= n and n <= 104
1 <= starting point of ith interval < ending point of ith interval <= 105
1 <= profit earned by choosing ith interval <= 105


class Solution {
    public static int maximum_profit(int n, int[][] intervals) {
        // code here
        if (n == 0 || intervals == null) {
            return 0;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        int [] dp = new int [n];
        dp[0] = intervals[0][2];
        for (int i = 1; i < n; i++) {
            int currentProfit = intervals[i][2];
            /*
            Find Profit including current Job:
            Find the latest job before the current job (in sorted array) 
            that doesn't conflict with current job 'jobs[n-1]'.
            */
            int index = binarySearch(i, intervals);
            if (index != -1) {
                currentProfit += dp[index];
            }
            dp[i] = Math.max(dp[i - 1], currentProfit);
        }
        return dp[n - 1];
    }
    
    private static int binarySearch(int index, int [][] intervals) {
        int low = 0;
        int high = index - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (intervals[middle][1] <= intervals[index][0]) {
                if (intervals[middle + 1][1] <= intervals[index][0]) {
                    low = middle + 1;
                }
                else {
                    return middle;
                }
            }
            else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
