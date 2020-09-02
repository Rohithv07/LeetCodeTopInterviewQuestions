Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.

Examples:

Input  : n = 3
Output : 4
Explanation
{1}, {2}, {3} : all single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N.

Output:
For each test case in a new line print the required answer mod 10^9+7.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
3
2
Output:
4
2

Solution:

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int friendsPair(int n) {
        int mod = 1000000007;
        long [] dp = new long[n+1];
        for (int i=0; i<=n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = (dp[i-1] + (i-1) * dp[i-2] % mod) % mod;
        }
        return (int)dp[n] % mod;
    }
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
		    int n = sc.nextInt();
		    System.out.println(friendsPair(n));
		}
	}
}
