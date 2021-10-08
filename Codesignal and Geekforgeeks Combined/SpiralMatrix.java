Given a matrix of size N x M. You have to find the Kth element which will obtain while traversing the matrix spirally starting from the top-left corner of the matrix.

Example 1:

Input: 
N = 3, M = 3, K = 4
A[] = {{1, 2, 3}, 
       {4, 5, 6}, 
       {7, 8, 9}}
Output: 
6
Explanation: Spiral traversal of matrix: 
{1, 2, 3, 6, 9, 8, 7, 4, 5}. Fourth element
is 6.
Example 2:

Input: 
N = 2, M = 2, K = 2 
A[] = {{1, 2},
       {3, 4}} 
Output: 
2
Explanation: Spiral traversal of matrix: 
{1, 2, 4, 3}. Second element is 2.
Your Task:  
You don't need to read input or print anything. Complete the function findK() which takes the matrix A[ ][ ], number of rows N, number of columns M, and integer K as input parameters and returns the Kth element in the spiral traversal of the matrix.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ K ≤ N*M ≤ 106

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
	    // Your code goes here
	    int lowRow = 0;
	    int lowCol = 0;
	    int highRow = n - 1;
	    int highCol = m - 1;
	    int countOfElement = 0;
	    while (lowRow <= highRow && lowCol <= highCol) {
	        for (int i=lowRow; i<=highCol; i++) {
	            countOfElement++;
	            if (countOfElement == k) {
	                return a[lowRow][i];
	            }
	        }
	        lowRow++;
	        for (int i=lowRow; i<=highRow; i++) {
	            countOfElement++;
	            if (countOfElement == k) {
	                return a[i][highCol];
	            }
	        }
	        highCol--;
	        if (lowRow <= highRow) {
	            for (int i=highCol; i>=lowCol; i--) {
	                countOfElement++;
	                if (countOfElement == k) {
	                    return a[highRow][i];
	                }
	            }
	            highRow--;
	        }
	        if (lowCol <= highCol) {
	            for (int i=highRow; i>=lowRow; i--) {
	                countOfElement++;
	                if (countOfElement == k) {
	                    return a[i][lowCol];
	                }
	            }
	            lowCol++;
	        }
	    }
	    return a[n - 1][m - 1];
	}
	
}