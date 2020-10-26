This question is asked by Apple. Given a staircase where the ith step has a non-negative cost associated with it given by cost[i], return the minimum cost of climbing to the top of the staircase. You may climb one or two steps at a time and you may start climbing from either the first or second step.

Ex: Given the following cost array…

cost = [5, 10, 20], return 10.

Ex: Given the following cost array…

cost = [1, 5, 10, 3, 7, 2], return 10.

// here we can either start from 1st or second and we can continue our steps either one or two steps
// so we create a dp array of size costLength + 1 and takes the min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
// the last index value will be our answer.


public int minCostClimbingStairs(int [] cost) {
	// initilise dp array
	int [] dp = new int[cost.length+1];
	// traverse through the dp from 2 and find the minimum and update the dp
	for (int i=2; i<=cost.length; i++) {
		dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
	}
	return dp[cost.length];
}
