Given a value N. In how many ways you can construct a grid of size N x 4 using tiles of size 1 x 4.


Example 1:

Input: N = 1
Output: 1
Explaination: We can arrange the tiles horizontally 
and this is the only way.

Example 2:

Input: N = 4
Output: 2
Explaination: The first way can be when all 
the 1 x 4 tiles are arranged horizontally. 
Second way can be when all the 1 x 4 tiles 
are arranged vertically.

Your Task:
You do not need to read input or print anything. Your task is to complete the function arrangeTiles() which takes the value N as input parameter and returns the number of ways to make N x 4 grid using 1 x 4 tiles.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 80

//User function Template for Java

class Solution{
    static long arrangeTiles(int n){
        // code here
        if (n == 1) {
            return 1;
        }
        long [] dp = new long [n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 4 >= 0 ? dp[i - 4] : 0);
        }
        return dp[n];
    }
}