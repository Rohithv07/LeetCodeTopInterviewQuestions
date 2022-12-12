You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45


/*
Lets try to come down the stairs from the top.
So if n = 1, we have only 1 option to reach very below that is 0, which is 1->0
if n = 2, we have 2 options. 2->1->0 or directly jump 2 steps 2->0
if n = 3, we have 3 options, 3->2->1->0 or 3->2->0 or 3->1->0
same way if n = 4, we have 4->3->2->1->0, 4->3->1->0, 4->2->1->0, 4->2->0, 4->3->2->0
a total of 5 different ways.

So what actually we have, from a particular step say step, we can either jump 1 step 
which make (step - 1) or we can jump 2 steps which make (step - 2).
The summation of this would provide the total number of ways.

So we can recursively try this approach and find the answer.
But the time complexity will be exponential and surely we will get TLE

If we look at the recurrance relation, we are doing fun(step - 1) + fun(step - 2)
which is the same as we do the fibonacci series.
And thats what we can do for this problem also.

We can memoize, the solution -> O(n) & O(stackSpace) + O(n)
We can apply the tabulation -> O(n) & O(n)
We can also do the space Optimisation -> O(n) & O(1)

*/


/*
TLE
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
*/

/*
Memoization
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int [] dp = new int [n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        return findTotalWays(dp, n);
    }
    
    private int findTotalWays(int [] dp, int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = findTotalWays(dp, n - 1) + findTotalWays(dp, n - 2);
    }
}
*/

/*
Tabulation

class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int [] dp = new int [n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
*/

//Space Optimization
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int starting = 2;
        while (starting <= n) {
            int third = first + second;
            second = first;
            first = third;
            starting++;
        }
        return first;
    }
}
