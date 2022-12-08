Given the chessboard dimensions. Find out the number of ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.

Note:
The knights have to be placed on different squares. A knight can move two squares horizontally and one square vertically (L shaped), or two squares vertically and one square horizontally (L shaped). The knights attack each other if one can reach the other in one move.

Example 1:

Input:
N = 2, M = 2
Output: 12 
Explanation: There are 12 ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.

Example 2:

Input:
N = 2, M = 3
Output: 26
Explanation: There are 26 ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.
Your Task:
Your task is to complete the function numOfWays() which takes the chessboard dimensions N and M as inputs and returns the number of ways we can place 2 Knights on this chessboard such that they cannot attack each other. Since this number can be very large, return it modulo 109+7.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N * M <= 105



class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    
    static long numOfWays(int n, int m)
    {
        // add your code here
        long result = 0;
        long total = n * m;
        final long MOD = (long)(1e9 + 7);
        final int [][] directions = new int [][]{
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long currentInvalidCount = 1; // invalid because we start by putting the black knight to the position where the white knight is currently
                for (int [] dir : directions) {
                    int newX = i + dir[0];
                    int newY = j + dir[1];
                    if (isSafe(n, m, newX, newY)) {
                        currentInvalidCount++;
                    }
                }
                result = (result + total - currentInvalidCount) % MOD;
            }
        }
        return result;
    }
    
    static boolean isSafe(int row, int col, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return false;
        }
        return true;
    }
}