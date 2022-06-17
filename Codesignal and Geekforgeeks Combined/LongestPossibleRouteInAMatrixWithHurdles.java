Given an N x M matrix, with a few hurdles(denoted by 0) arbitrarily placed, calculate the length of the longest possible route possible from source(xs,ys) to a destination(xd,yd) within the matrix. We are allowed to move to only adjacent cells which are not hurdles. The route cannot contain any diagonal moves and a location once visited in a particular path cannot be visited again.If it is impossible to reach the destination from the source return -1.

 

Example 1:

Input:
{xs,ys} = {0,0}
{xd,yd} = {1,8}
matrix = 1 1 1 1 1 1 1 1 1 1
         1 1 0 1 1 0 1 1 0 1
         1 1 1 1 1 1 1 1 1 1
Output: 24
Explanation:

 

Example 2:

Input: 
{xs,ys} = {0,3}
{xd,yd} = {2,2}
matrix = 1 0 0 1 0
         0 0 0 1 0
         0 1 1 0 0
Output: -1
Explanation:
We can see that it is impossible to
reach the cell (2,2) from (0,3).
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPath() which takes matrix ,source and destination as input parameters and returns an integer denoting the longest path.


Expected Time Complexity: O(2^(N*M))
Expected Auxiliary Space: O(N*M)


Constraints:
1 <= N,M <= 10


class Solution {
    
    private final static int [][] direction = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
        // code here
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }
        if (xs == xd && ys == yd) {
            return 0;
        }
        int [] longestPathLength = new int [1];
        longestPathLength[0] = -1;
        findLongestPath(mat, xs, ys, xd, yd, longestPathLength, 0);
        return longestPathLength[0];
    }
    
    private static void findLongestPath(int [][] mat, int i, int j, int xd, int yd, int [] longestPathLength, int currentLength) {
        if (i == xd && j == yd && currentLength > longestPathLength[0]) {
            longestPathLength[0] = currentLength;
            return;
        }
        mat[i][j] = -1;
        for (int [] dir : direction) {
            int newX = dir[0] + i;
            int newY = dir[1] + j;
            if (isSafe(mat, newX, newY)) {
                mat[newX][newY] = -1;
                currentLength += 1;
                findLongestPath(mat, newX, newY, xd, yd, longestPathLength, currentLength);
                currentLength -= 1;
                mat[newX][newY] = 1;
            }
        }
        mat[i][j] = 1;
        
    }
    
    private static boolean isSafe(int [][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != 1) {
            return false;
        }
        return true;
    }
}
        
