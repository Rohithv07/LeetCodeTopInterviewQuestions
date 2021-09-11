Given a binary matrix M of size n X m. Find the maximum area of a rectangle formed only of 1s in the given matrix.

Example 1:

Input:
n = 4, m = 4
M[][] = {{0 1 1 0},
         {1 1 1 1},
         {1 1 1 1},
         {1 1 0 0}}
Output: 8
Explanation: For the above test case the
matrix will look like
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
the max size rectangle is 
1 1 1 1
1 1 1 1
and area is 4 *2 = 8.
Your Task: 
Your task is to complete the function maxArea which returns the maximum size rectangle area in a binary-sub-matrix with all 1’s. The function takes 3 arguments the first argument is the Matrix M[ ] [ ] and the next two are two integers n and m which denotes the size of the matrix M. 

Expected Time Complexity : O(n*m)
Expected Auixiliary Space : O(m)

Constraints:
1<=n,m<=1000
0<=M[][]<=1

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.



/*Complete the function given below*/
class Solution {
    public int maxArea(int matrix[][], int n, int m) {
        // add code here.
        if (matrix == null || n == 0)
            return 0;
        int [][] dp = new int [n][m];
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                }
                else {
                    if (matrix[i][j] == 1)
                        dp[i][j] = dp[i - 1][j] + matrix[i][j];
                }
            }
        }
        for (int [] row : dp) {
            max = Math.max(max, largestRectangleHistogram(row));
        }
        return max;
    }
    
    private int largestRectangleHistogram(int [] nums) {
        int length = nums.length;
        int [] left = new int [length];
        int [] right = new int [length];
        left[0] = -1;
        right[length - 1] = length;
        for (int i=1; i<length; i++) {
            int current = i - 1;
            while (current >= 0 && nums[current] >= nums[i]) {
                current = left[current];
            }
            left[i] = current;
        }
        for (int i=length-2; i>=0; i--) {
            int current = i + 1;
            while (current < length && nums[current] >= nums[i]) {
                current = right[current];
            }
            right[i] = current;
        }
        int maxRectangle = 0;
        for (int i=0; i<length; i++) {
            maxRectangle = Math.max(maxRectangle, nums[i] * (right[i] - left[i] - 1));
        }
        return maxRectangle;
    }
    
}