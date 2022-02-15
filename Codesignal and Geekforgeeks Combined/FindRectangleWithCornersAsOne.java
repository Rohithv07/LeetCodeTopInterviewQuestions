Given a NxM binary matrix consisting of 0s and 1s. Find if there exists a rectangle/ square within the matrix whose all four corners are 1. 

Example 1:

Input:
N = 4, M = 5
matrix[][] = 
{
{1 0 0 1 0},
{0 0 1 0 1},
{0 0 0 1 0}, 
{1 0 1 0 1}
} 

Output: Yes
Explanation:
Valid corners are at index (1,2), (1,4), (3,2), (3,4) 
Example 2:

Input:
N = 3, M = 3
matrix[][] = 
{{0 0 0},
{0 0 0},
{0 0 0}}
Output: No
Your Task:
You don't need to take input or print anything. Complete the function ValidCorners() that takes the given matrix as input parameter and returns a boolean value.

Constraints:
1 <= R, C <= 200
0 <= A[i] <= 1

//User function Template for Java

public class Solution { 
	static boolean ValidCorner(int matrix[][]) 
	{ 
	    // Your code goes here
	    int row = matrix.length;
	    int col = matrix[0].length;
	    for (int i = 0; i < row; i++) {
	        for (int j = 0; j < col; j++) {
	            if (matrix[i][j] == 1) {
	                for (int k = i + 1; k < row; k++) {
	                    if (matrix[k][j] == 1) {
	                        for (int l = j + 1; l < col; l++) {
	                            if (matrix[i][l] == 1 && matrix[k][l] == 1) {
	                                return true;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }
	    return false;
	}
}