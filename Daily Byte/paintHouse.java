Good morning,

Today's Byte

This question is asked by Apple. You are tasked with painting a row of houses in your neighborhood such that each house is painted either red, blue, or green. The cost of painting the ith house red, blue or green, is given by costs[i][0], costs[i][1], and costs[i][2] respectively. Given that you are required to paint each house and no two adjacent houses may be the same color, return the minimum cost to paint all the houses.

Ex: Given the following costs array…

costs = [[1, 3, 5],[2, 4, 6],[5, 4, 3]], return 8.
Paint the first house red, paint the second house blue, and paint the third house green.

// so here we have 3 option
// if we opt red first, then the next can be the min from the previous blue or green
// if we opt blue first, then the next can be the min from the previous red or green
// and the same wiht the green and we need to take the sum

import java.util.*;
public class Solution {
	public static int paintHouse(int [][] cost) {
		if (cost.length == 0 || cost == null)
			return 0;
		for (int i=1; i<cost.length; i++) {
			// red
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
			// blue
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
			// green 
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
		}
		// the value will be at the end and we need the minimum from all
		return Math.min(cost[cost.length-1][0], Math.min(cost[cost.length-1][1], cost[cost.length-1][2]));
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int [][] cost = new int [3][3];
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
				cost[i][j] = sc.nextInt();
		System.out.println(paintHouse(cost));
	}
}

// here we changes the input array and here we are traversing thoruhg the cost array once, so O(cost.length)

// if we can't change the input array, then we can make use of a dp array

	public static int paintHouse(int [][] cost) {
		int length = cost.length;
		if (length == 0 || cost == null)
			return 0;
		// create a dp array with length rows and 3 col
		int [][] dp = new int [length][3];
		for (int i=0; i<length; i++) {
			if (i == 0) {
				dp[i][0] = cost[i][0];
				dp[i][1] = cost[i][1];
				dp[i][2] = cost[i][2];
			}
			else {
				// red
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
				// blue
				dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0]) + cost[i][1];
				// green
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
			}
		}
		return Math.min(dp[length-1][0], Math.min(dp[length-1][1], dp[length-1][2]));
	}

// but this is giving wrong output while checking with te both functions, so prefer the answer by changing the input array than this answer.
