Given a grid of size M*N with each cell consisting of an integer which represents points. We can move across a cell only if we have positive points. Whenever we pass through a cell, points in that cell are added to our overall points, the task is to find minimum initial points to reach cell (m-1, n-1) from (0, 0) by following these certain set of rules :
 
1. From a cell (i, j) we can move to (i + 1, j) or (i, j + 1).
2. We cannot move from (i, j) if your overall points at (i, j) are <= 0.
3. We have to reach at (n-1, m-1) with minimum positive points i.e., > 0.

Example 1:

Input: M = 3, N = 3 
       arr[][] = {{-2,-3,3}, 
                  {-5,-10,1}, 
                  {10,30,-5}}; 

Output: 7
Explanation: 7 is the minimum value to
reach the destination with positive
throughout the path. Below is the path.
(0,0) -> (0,1) -> (0,2) -> (1, 2) -> (2, 2)
We start from (0, 0) with 7, we reach
(0, 1) with 5, (0, 2) with 2, (1, 2)
with 5, (2, 2) with and finally we have
1 point (we needed greater than 0 points
at the end).
Example 2:
Input: M = 3, N = 2
       arr[][] = {{2,3}, 
                  {5,10}, 
                  {10,30}}; 
Output: 1
Explanation: Take any path, all of them 
are positive. So, required one point 
at the start

Your Task:  
You don't need to read input or print anything. Complete the function minPoints() which takes N, M and 2-d vector as input parameters and returns the integer value

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)



class Solution
{
	public int minPoints(int points[][],int M,int N) 
	{ 
	    // Your code goes here
	    int [][] dp = new int [M+1][N+1];
	    for (int i=0; i<=M; i++) {
	        Arrays.fill(dp[i], Integer.MAX_VALUE);
	    }
	    dp[M-1][N] = 1;
	    dp[M][N-1] = 1;
	    for (int i=M-1; i>=0; i--) {
	        for (int j=N-1; j>=0; j--) {
	            int minimum = Math.min(dp[i+1][j], dp[i][j+1]) - points[i][j];
	            dp[i][j] = minimum <= 0 ? 1 : minimum;
	        }
	    }
	    return dp[0][0];
	} 
}
