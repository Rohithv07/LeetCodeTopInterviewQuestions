You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines. The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.

Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.

An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right, and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.

 

Example 1:


Input: n = 5, mines = [[4,2]]
Output: 2
Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.
Example 2:


Input: n = 1, mines = [[0,0]]
Output: 0
Explanation: There is no plus sign, so return 0.
 

Constraints:

1 <= n <= 500
1 <= mines.length <= 5000
0 <= xi, yi < n
All the pairs (xi, yi) are unique.



// Using single 2d array ref : https://leetcode.com/problems/largest-plus-sign/discuss/146531/java-simple-DP-solution-using-one-matrix-easy-to-undersatnd

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int [][] grid = new int [n][n];
        for (int [] g : grid) {
            Arrays.fill(g, 1);
        }
        for (int [] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        int answer = 0;
        if (mines.length < n * n)
            answer = 1;
        int [][] leftPart = new int [n][n];
        int [][] rightPart = new int [n][n];
        int [][] topPart = new int [n][n];
        int [][] bottomPart = new int [n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    leftPart[i][j] = 0;
                    topPart[i][j] = 0;
                }
                else {
                    leftPart[i][j] = (j - 1 >= 0) ? leftPart[i][j - 1] + 1 : 1;
                    topPart[i][j] = (i - 1 >= 0) ? topPart[i - 1][j] + 1 : 1;
                }
            }
        }
        for (int i=n-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (grid[i][j] == 0) {
                    rightPart[i][j] = 0;
                    bottomPart[i][j] = 0;
                }
                else {
                    rightPart[i][j] = (j + 1 < n) ? rightPart[i][j + 1] + 1 : 1;
                    bottomPart[i][j] = (i + 1 < n) ? bottomPart[i + 1][j] + 1 : 1;
                }
                answer = Math.max(answer, Math.min(Math.min(leftPart[i][j], bottomPart[i][j]), Math.min(rightPart[i][j], topPart[i][j])));
            }
        }
        return answer;
    }
}




// using single array
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int [][] grid = new int [n][n];
        for (int [] g : grid) {
            Arrays.fill(g, 1);
        }
        for (int [] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        int answer = 0;
        if (mines.length < n * n)
            answer = 1;
        int count = 0;
        for (int i=0; i<n; i++) {
            count = 0;
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    count = 0;
                }
                else {
                    count++;
                }
                grid[i][j] = count;
            }
            count = 0;
            for (int j=n-1; j>=0; j--) {
                if (grid[i][j] == 0) {
                    count = 0;
                }
                else {
                    count ++;
                }
                grid[i][j] = Math.min(grid[i][j], count);
            }
        }
        for (int j=0; j<n; j++) {
            count = 0;
            for (int i=0; i<n; i++) {
                if (grid[i][j] == 0) {
                    count = 0;
                }
                else {
                    count++;
                }
                grid[i][j] = Math.min(grid[i][j], count);
            }
            count = 0;
            for (int i=n-1; i>=0; i--) {
                if (grid[i][j] == 0) {
                    count = 0;
                }
                else {
                    count++;
                }
                grid[i][j] = Math.min(grid[i][j], count);
                answer = Math.max(answer, grid[i][j]);
            }
        }
        return answer;
    }
}