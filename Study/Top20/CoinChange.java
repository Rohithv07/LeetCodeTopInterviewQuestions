/*
 * 1. Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer. 

Examples:

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].
Input: coins[] = [2, 5, 3, 6], sum = 10
Output: 5
Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5].
Input: coins[] = [5, 10], sum = 3
Output: 0
Explanation: Since all coin denominations are greater than sum, no combination can make the target sum.
Constraints:
1 <= sum <= 103
1 <= coins[i] <= 104
1 <= coins.size() <= 103

class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int length = coins.length;
        if (length == 0 || coins == null) {
            return 0;
        }
        int [][] dp = new int [length][sum + 1];
        for (int target = 0; target <= sum; target++) {
            dp[0][target] = target % coins[0] == 0 ? 1 : 0;
        }
        for (int index = 1; index < length; index++) {
            for (int target = 0; target <= sum; target++) {
                int notPick = dp[index - 1][target];
                int pick = 0;
                if (target >= coins[index]) {
                    pick = dp[index][target - coins[index]];
                }
                dp[index][target] = notPick + pick;
            }
        }
        return dp[length - 1][sum];
    }
    
    private int findWay(int [] coins, int index, int sum, int [][] dp) {
        if (index == 0) {
            return sum % coins[index] == 0 ? 1 : 0;
        }
        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }
        int notPick = findWay(coins, index - 1, sum, dp);
        int pick = 0;
        if (sum >= coins[index]) {
            pick = findWay(coins, index, sum - coins[index], dp);
        }
        return dp[index][sum] = pick + notPick;
    }
}




2. You are given an array coins[], where each element represents a coin of a different denomination, and a target value sum. You have an unlimited supply of each coin type {coins1, coins2, ..., coinsm}.

Your task is to determine the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.

Examples:

Input: coins[] = [25, 10, 5], sum = 30
Output: 2
Explanation: Minimum 2 coins needed, 25 and 5  
Input: coins[] = [9, 6, 5, 1], sum = 19
Output: 3
Explanation: 19 = 9 + 9 + 1
Input: coins[] = [5, 1], sum = 0
Output: 0
Explanation: For 0 sum, we do not need a coin
Input: coins[] = [4, 6, 2], sum = 5
Output: -1
Explanation: Not possible to make the given sum.
 
Constraints:
1 ≤ sum * coins.size() ≤ 106
0 <= sum <= 104
1 <= coins[i] <= 104
1 <= coins.size() <= 103



class Solution {

    private static final int MAX = (int)(1e9);
    public int minCoins(int coins[], int sum) {
        // code here
        if (coins == null || coins.length == 0 || sum < 0) {
            return -1;
        }
        int length = coins.length;
        int [][] dp = new int [length + 1][sum + 1];
        int [] previous = new int [sum + 1];
        int [] current = new int [sum + 1];
        for (int [] d : dp) {
            Arrays.fill(d, -1);
        }
        for (int target = 0; target <= sum; target++) {
            if (target % coins[0] == 0)
                previous[target] = target / coins[0];
            else
                previous[target] = MAX;
        }
        for (int index = 1; index <= length; index++) {
            for (int target = 0; target <= sum; target++) {
                int notPick = previous[target];
                int pick = MAX;
                if (target >= coins[index - 1]) {
                    pick = 1 + current[target - coins[index - 1]];
                }
                current[target] = Math.min(pick, notPick);
            }
            int [] temp = previous;
            previous = current;
            current = previous;
        }
        //int minCoinsCount = findMinCoins(coins, sum, coins.length - 1, dp);
        //return minCoinsCount == MAX ? -1 : minCoinsCount;
        return previous[sum] == MAX ? -1 : previous[sum];
    }
    
    private int findMinCoins(int [] coins, int sum, int index, int [][] dp) {
        if (index == 0) {
            return sum % coins[index] == 0 ? sum / coins[index] : MAX;
        }
        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }
        int notPick = findMinCoins(coins, sum, index - 1, dp);
        int pick = MAX;
        if (sum >= coins[index]) {
            pick = 1 + findMinCoins(coins, sum - coins[index], index, dp);
        }
        return dp[index][sum] = Math.min(pick, notPick);
    }
}
 */