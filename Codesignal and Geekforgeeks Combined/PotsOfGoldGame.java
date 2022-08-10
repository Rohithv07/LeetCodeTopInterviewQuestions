Two players X and Y are playing a game in which there are pots of gold arranged in a line, each containing some gold coins. They get alternating turns in which the player can pick a pot from one of the ends of the line. The winner is the player who has a higher number of coins at the end. The objective is to maximize the number of coins collected by X, assuming Y also plays optimally.

Return the maximum coins X could get while playing the game. Initially, X starts the game.


Example 1:

Input:
N = 4
Q[] = {8, 15, 3, 7}
Output: 22
Explanation: Player X starts and picks 7. Player Y 
picks the pot containing 8. Player X picks the pot
containing 15. Player Y picks 3.
Total coins collected by X = 7 + 15 = 22.
Example 2:

Input:
N = 4
A[] = {2, 2, 2, 2}
Output: 4 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxCoins() which takes an integer N and an array of size N  as input and returns the maximum coins collected by player X.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)


Constraints:
1 <= N <= 500
1 <= A[i] <= 103



/*Complete the function below*/
class GfG
{
	public static int maxCoins(int a[],int n)
	{
          //add code here.
          int [][] dp = new int [n + 1][n + 1];
          for (int [] d : dp) {
              Arrays.fill(d, -1);
          }
          return memo(0, n - 1, a, dp);
    }
    
    public static int memo(int left, int right, int [] a, int [][] dp) {
        if (left == right) {
            return a[left];
        }
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        // here we take maximum of minimums because our opponent plays optimally and we can't always get the maximum amount of gold.
        // our opponent will always try to reduce the amount of gold
        // so from those minimum gold, we will take the maximum result
        return dp[left][right] = Math.max(a[left] + Math.min(memo(left + 2, right, a, dp), memo(left + 1, right - 1, a, dp)),
        a[right] + Math.min(memo(left, right - 2, a, dp), memo(left + 1, right - 1, a, dp)));
    }
}