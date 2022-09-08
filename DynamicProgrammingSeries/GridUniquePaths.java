// https://www.youtube.com/watch?v=sdE0A2Oxofw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=9


/*
1. Represent in terms of index : 

So here we are given row and col. We start from the very top left cell which is the starting point and we need to reach the very bottom right corner. The only movement available to us is either move down or move right. Move down means our row changes, move right means our column changes. So we represent this problem in terms of row and column index.
f(row, col)

2. Do the stuff on that index and take min/max/count ways based on problem : 
Now we have represented the problem in terms of index, f(row, col)

Let us start from the very bottom. We can also start from the top and go all the way down. But lets say f(row, col) denotes the number of paths to reach the position {row, col}.

So now we are at a position {row, col}. We need to reach {0, 0} which is the starting position as per the question. We have 2 possible moves, either we move up which decreases the row count or we move left which decreases the column.

upMove = f(row - 1, col)
leftMove = f(row, col - 1)

We know, whenever we reach {0, 0} position, we have a unique path and we can return 1. This is the base case.
if (row == 0 && col == 0) {
return 1.
}
Also there is an edge case. We too need to worry about the boundaries.
If we go out of bound, we need to return 0 blindly as it will not surely contribute to any path.
if (outOfBoundary) {
return 0;
}

Other wise, we try out all our possible upper and left move and return their total sum.
return upMove + leftMove

This recursive solution will surely get TLE as there are many overlapping subproblems which can be addressed by introducing memoization.



*/


import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
        return findAllWaysCount(m - 1, n - 1);
	}
    
    private static int findAllWaysCount(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        int upper = findAllWaysCount(row - 1, col);
        int left = findAllWaysCount(row, col - 1);
        return upper + left;
    }
}
/*
For memoization, the step is simple.
When we understood that there are subproblems, then we can apply.
If we draw a sample recursion tree for any test case, we can see many overlapping subproblems.

The first step is memoization. The idea is simple
1. Declare an m X n dp array and initialise by -1.
2. in our recursive solution, there is return up + left, instead of that, apply return dp[row][col] = up + left
3. Also have a check whether we have already computed a particular step in past.

TC : O(M * N)
SC : O(M * N) + O(StackSpace)
*/

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
        
        int [][] dp = new int [m][n];
        for (int [] d : dp) {
            Arrays.fill(d, -1);
        }
        return findUniquePath(m - 1, n - 1, dp);
	}
    
    private static int findUniquePath(int row, int col, int [][] dp) {
        if (row == 0 && col == 0) {
            return dp[row][col] = 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        }
        if (dp[row][col] != -1) {
            // we alreadt computed this step before
            return dp[row][col];
        }
        int upMove = findUniquePath(row - 1, col, dp);
        int leftMove = findUniquePath(row, col - 1, dp);
        return dp[row][col] = upMove + leftMove;
    }
}

/*
We can reduce the space further by making use of tabulation method
1. Populate the base case in dp table
2. Take all the states of dp in the for loops.
3. COpy the recurrance and change the function call to dp variable.

TC : O(M * N)
SC : O(M * N)
*/


import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
        int [][] dp = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
	}
}
/*

If there is a case of previous row, previous column, then there is a chance of space optimisation

We just required the previous row values, inorder to take the values if we are considering the upper move

TC : O(M * N)
SC : O(N)

*/


import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
        int [] previousRow = new int [n]; // in a row there are n columns
        for (int i = 0; i < m; i++) {
            int [] currentRow = new int [n];
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    currentRow[j] = 1;
                }
                else {
                    // left from current row + up and the up value will be taken from previousRow
                    currentRow[j] = currentRow[j - 1] + previousRow[j];
                }
            }
            previousRow = currentRow;
            // now take whatever values inside temp and save inside the previousRow array for the next compuations
        }
        return previousRow[n - 1];
	}
}
/*
There is also a better solution using Combinations.
m+n-2Cm-1. or m + n - 2 C n - 1
*/

class Solution {
    public int uniquePaths(int m, int n) {
        // NCR where N = n + m - 2 and R = m - 1 or n - 1
        
        int N = n + m - 2;
        int R = m - 1;
        double result = 1;
        for (int i = 1; i <= R; i++) {
            result = result * (N - R + i) / i;
        }
        return (int)result;
    }
}