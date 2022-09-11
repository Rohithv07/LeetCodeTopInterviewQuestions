// https://www.youtube.com/watch?v=zA4PpSPDh30

// https://practice.geeksforgeeks.org/contest/interview-series-67/problems/



//User function Template for Java
class Solution
{
    public static boolean gridSum(int grid[][],int k)
    {
        int row = grid.length;
        int col = grid[0].length;
        if ((row + col) % 2 == Math.abs(k) % 2) {
            return false;
        }
        // we find the min path sum and max path sum and if k lies in that range
        // we return true else false
        int [][] dpMin = new int [row + 1][col + 1];
        int [][] dpMax = new int [row + 1][col + 1];
        dpMin[row - 1][col - 1] = grid[row - 1][col - 1];
        dpMax[row - 1][col - 1] = grid[row - 1][col - 1];
        for (int i = row - 2; i>=0; i--) {
            dpMin[i][col - 1] = dpMin[i + 1][col - 1] + grid[i][col - 1];
            dpMax[i][col - 1] = dpMax[i + 1][col - 1] + grid[i][col - 1];
        }
        for (int i = col - 2; i>=0; i--) {
            dpMin[row - 1][i] = dpMin[row - 1][i + 1] + grid[row - 1][i];
            dpMax[row - 1][i] = dpMax[row - 1][i + 1] + grid[row - 1][i];
        }
        //dpMin[row - 1][col - 1] = grid[row - 1][col - 1];
        //dpMax[row - 1][col - 1] = grid[row - 1][col - 1];
        
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
               
                    dpMin[i][j] = Math.min(dpMin[i + 1][j], dpMin[i][j + 1]) + grid[i][j];
                    dpMax[i][j] = Math.max(dpMax[i + 1][j], dpMax[i][j + 1]) + grid[i][j];
            }
        }
        int minValue = dpMin[0][0];
        int maxValue = dpMax[0][0];
        return minValue <= k && k <= maxValue;
    }
}