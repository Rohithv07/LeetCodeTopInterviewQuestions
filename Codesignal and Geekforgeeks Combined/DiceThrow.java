Given N dice each with M faces, numbered from 1 to M, find the number of ways to get sum X. X is the summation of values on each face when all the dice are thrown.

 

Example 1:

Input:
M = 6, N = 3, X = 12
Output:
25
Explanation:
There are 25 total ways to get
the Sum 12 using 3 dices with
faces from 1 to 6.
Example 2:

Input:
M = 2, N = 3, X = 6
Output:
1
Explanation:
There is only 1 way to get
the Sum 6 using 3 dices with
faces from 1 to 2. All the
dices will have to land on 2.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function noOfWays() which takes 3 Integers M,N and X as input and returns the answer.

 

Expected Time Complexity: O(M*N*X)
Expected Auxiliary Space: O(N*X)

 

Constraints:
1 <= M,N,X <= 50


class Solution {
    static long noOfWays(int f , int d , int target) {
        // code here
        long [][] dp = new long [d + 1][target + 1];
        long mod = (long)1e9 + 7;
        for (int i=0; i<=d; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (long)memo(d, f, target, dp, mod);
    }
    
    static long memo(int d, int f, int target, long [][] dp, long mod) {
        if (d == 0 && target == 0)
            return 1;
        if (d > target || d * f < target)
            return 0;
        if (dp[d][target] != -1)
            return dp[d][target];
        long answer = 0l;
        for (int i=1; i<=f && i<=target; i++) {
            if (target - i >= 0) {
                answer = (answer + memo(d - 1, f, target - i, dp, mod));
            }
            else {
                break;
            }
        }
        return dp[d][target] = answer;
    }
}