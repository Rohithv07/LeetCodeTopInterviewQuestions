Given a list of coins of distinct denominations and total amount of money. Find the minimum number of coins required to make up that amount. Output -1 if that money cannot be made up using given coins.
You may assume that there are infinite numbers of coins of each type.
 

Example 1:

Input: arr = [1, 2, 5], amount = 11
Output: 3
Explanation: 2*5 + 1 = 11. So taking 2 
denominations of 5 and 1 denomination of  
1, one can make 11.
Example 2:

Input: arr = [2, 6], amount = 7
Output: -1
Explanation: Not possible to make 7 using 
denominations 2 and 6.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function MinCoin() which takes list of denominations and amount as input parameter and returns miimum number of coins to make up amount. If not possible returns -1.
 

Expected Time Complexity: O(n*amount)
Expected Space Complexity: O(amount)
 

Contstraints:
1 <= number of distinct denominations <= 100
1 <= amount <= 104



//User function Template for Java

class Solution
{
    public int MinCoin(int[] nums, int amount)
    {
        // Code here
        int [] dp = new int [amount + 1];
        int length = nums.length;
        Arrays.fill(dp, amount + 2);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < length; j++) {
                if (i >= nums[j]) {
                    // we can either skip the current coin or we can consider the current coin
                    dp[i] = Math.min(dp[i], dp[i - nums[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}