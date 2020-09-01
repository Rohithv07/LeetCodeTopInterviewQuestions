Given a floor of dimensions 2 x W and tiles of dimensions 2 x 1, the task is to find the number of ways the floor can be tiled. A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is W.

Output:
Print number of ways the floor can be tiled in a separate line.

Constraints:
1 ≤ T ≤ 50
1 ≤ W ≤ 70

Example:
Input
2
5
3

Output
8
3

Solution :

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static long tileFloor(int n) {
        long [] dp = new long [n+2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- >0) {
		    int n = sc.nextInt();
		    System.out.println(tileFloor(n));
		}
	}
}
