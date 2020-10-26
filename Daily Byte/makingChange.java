This question is asked by Facebook. Given an array that represents different coin denominations and an amount of change you need to make, return the fewest number of coins it takes to make the given amount of change.
Note: If it is not possible to create the amount of change with the coins you’re given, return -1.

Ex: Given the following denominations and amount…

coins = [1,5, 10, 25], amount = 78, return 6
Take three 25 coins and three 1 coins for a total of 6 coins.


// here I first think of sorting the array and taking the largest amount upto a moment where further addition of that will result in greater, so then take the next larger and so on and track the count too. If we cant reach the amount or exceed the amount everytime, then we can return -1 otherwise we can return the count
// but this wont produce some results and dynamic programming is the way to go
// we create a dynamic array of length amount+1 and initialise 0th as 0 and the rest as maximum.
// now we start of with amount = 1 and through the coin array we check for the coins whether its less than the current amount or not, 
// if yes, then we keep track of dp[i-coins[j]]
// if its not maxValue and track+1 < dp[i], we update the dp[i]
// atlast we check whether the last exceeds amount or not if not return dp[amount] else -1

public int coinChange(int [] coins, int amount) {
	// create dp array
	int [] dp = new int[amount+1];
	// fill the dp array
	dp[0] = 0;
	for (int i=1; i<=amount; i++)
		dp[i] = Integer.MAX_VALUE;
	// traverse through dp array and coins array
	for (int i=1; i<=amount; i++) {
		for (int j=0; j<coins.length; j++) {
			// if our current coin < the current amount
			if (coins[j] <= i) {
				int sub = dp[i-coins[j]];
				if (sub != Integer.MAX_VALUE && sub+1 < dp[i])
					dp[i] =sub + 1;
			}
		}
	}
	return dp[amount] > amount ? -1 : dp[amount];
} 
