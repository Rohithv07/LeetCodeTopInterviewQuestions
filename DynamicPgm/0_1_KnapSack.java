/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int knapSack(int weight, int wt[], int val[], int n) {
        int [][] dp = new int [n+1][weight+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=weight; j++) {
                if (i==0 || j==0)
                    dp[i][j] = 0;
                else if (wt[i-1] <= j) 
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],
                    dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
                }
            }
            return dp[n][weight];
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
		    int v = sc.nextInt();
		    int w = sc.nextInt();
		    int [] value = new int[v];
		    int [] weights = new int[v];
		    for (int i=0; i<v; i++)
		        value[i] = sc.nextInt();
		    for (int i=0; i<v; i++) {
		        weights[i] = sc.nextInt();
		    }
		    System.out.println(knapSack(w, weights, value, v));
		}
	}
}
