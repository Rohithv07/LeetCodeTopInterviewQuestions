Given N friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
Note: Since answer can be very large, return your answer mod 10^9+7.


Example 1:

Input:N = 3
Output: 4
Explanation:
{1}, {2}, {3} : All single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.
Example 2: 

Input: N = 2
Output: 2
Explanation:
{1} , {2} : All single.
{1,2} : 1 and 2 are paired.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countFriendsPairings() which accepts an integer n and return number of ways in which friends can remain single or can be paired up.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 104



class Solution
{
    
    private final long MOD = (long)(1e9 + 7); 
    
    public long countFriendsPairings(int n) 
    { 
       //code here
       // 2 conditions
       // either single or pair
       // single means, we still have n - 1 numbers remaining
       // paired means, we still have n - 2 numbers remaining
       if (n == 1) {
           return 1;
       }
       if (n == 2) {
           return 2;
       } 
       long [] dp = new long [n + 1];
       Arrays.fill(dp, -1l);
       dp[0] = 1l;
       dp[1] = 1l;
       dp[2] = 2l;
       return findUsingMemo(n, dp);
    }
    
    private long findUsingMemo(int n, long [] dp) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        // remains single
        long single = (findUsingMemo(n - 1, dp)) % MOD;
        // paired up with any of the remaining n - 1persons
        long paired = (((n - 1) * (findUsingMemo(n - 2, dp))) % MOD) % MOD;
        return dp[n] = (single % MOD + paired % MOD) % MOD;
    }
}    
 