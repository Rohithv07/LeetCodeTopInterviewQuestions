Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find the number of distinct combinations to reach the given score.

Input:
The first line of input contains an integer T denoting the number of test cases. T test cases follow. The first line of each test case is n.

Output:
For each testcase, in a new line, print the number of ways/combinations to reach the given score.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ T ≤ 100
1 ≤ n ≤ 1000

Example:
Input:
3
8
20
13

Output:
1
4
2

Explanation
For 1st example when n = 8
{ 3, 5 } and {5, 3} are the two possible permutations but these represent the same cobmination. Hence output is 1.

Solution:

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int numberOfWays(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i=3; i<=n; i++) 
            dp[i] = dp[i] + dp[i-3];
        for (int i=5; i<=n; i++)
            dp[i] = dp[i] + dp[i-5];
        for (int i=10; i<=n; i++)
            dp[i] = dp[i] + dp[i-10];
        return dp[n];
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- >0) {
		    int target = sc.nextInt();
		    System.out.println(numberOfWays(target));
		}
	}
}
