You’ve broken into an art gallery and want to maximize the value of the paintings you steal. 
All the paintings you steal you place in your bag which can hold at most W pounds. 
Given that the weight and value of the ith painting is given by weights[i] and values[i] respectively, 
return the maximum value you can steal.

Ex: Given the following W, weights array and values array…

W = 10, weights = [4, 1, 3], values = [4, 2, 7], return 13.

Ex: Given the following W, weights array and values array…

W = 5, weights = [2, 4, 3], values = [3, 7, 2], return 7.

Ex: Given the following W, weights array and values array…

W = 7, weights = [1, 3, 4], values = [3, 5, 6], return 11.


// 0/1 knapsack
import java.util.*;
public class Solution {
	public static int knapsack(int w, int [] weight, int [] value, int n) {
		// create dp array
		int [][] dp = new int [n+1][w+1];
		for (int i=0; i<=n; i++) {
			for (int j=0; j<=w; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (weight[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(value[i-1] + dp[i-1][j-weight[i-1]], dp[i-1][j]);
			}
		}
		return dp[n][w];
	}
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] weight = new int [n];
		for (int i=0; i<n; i++)
			weight[i] = sc.nextInt();
		int [] values = new int [n];
		for (int i=0; i<n; i++) 
			values[i] = sc.nextInt();
		int w = sc.nextInt();
		System.out.println(knapsack(w, weight, values, n));
	}
}