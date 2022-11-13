Given n buckets and infinite number of balls. The maximum capacity of each bucket is given in an array capacity[]. Find the number of ways to fill the buckets with balls such that each bucket has atleast 1 ball and all the buckets have distinct number of balls in them.
Note: Since the answer may be very large, calculate the answer modulo 10^9+7.

Example 1:

Input: 
n = 1
capacity = [6]
Output: 6
Explanation: Since there is only one 
bucket. It may hold any number of balls 
ranging from 1 to 6.

Example 2:

Input: 
n = 2 
capacity = [5, 8]
Output: 35
Explanation: If the first bucket has 1
ball in it then the second bucket cant have 1 
ball, so the second bucket has 8-1 = 7 choices.
So the first bucket has 5 choices and for each
choice second bucket has 7 choices.
So total there are 35 ways.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function totalWays() which takes n and capacity[] as input parameters and returns the number of possible ways to fill the buckets. Since the answer may be very large, calculate the answer modulo 10^9+7.

Expected Time Complexity: O(n*log(n)) 
Expected Space Complexity: O(1)

Constraints:
1 <= n <= 100000
1 <= capacity[i] <= 100000


//User function Template for Java

class Solution{
    public int totalWays(int n, int[] capacity) {
        // code here
        if (n == 1) {
            return capacity[0];
        }
        final long MOD = (long)(1e9 + 7);
        Arrays.sort(capacity);
        long result = capacity[0];
        for (int i = 1; i < n; i++) {
            int val = capacity[i];
            result = (result * (val  - i)) % MOD;
        }
        return (int)result;
    }
}