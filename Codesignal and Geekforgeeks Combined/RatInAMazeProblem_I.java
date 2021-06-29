Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.
Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will output "-1" automatically.

Expected Time Complexity: O((N2)4).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

Constraints:
2 ≤ N ≤ 5
0 ≤ m[i][j] ≤ 1




class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        if (m == null || n == 0)
            return new ArrayList<>();
        if (m[0][0] == 0)
            return new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        backtrack(result, m, n, "", 0, 0);
        Collections.sort(result);
        return result;
    }
    
    public static void backtrack(ArrayList<String> result, int [][] m, int n, String current, int start, int end) {
        if (!isSafe(m, start, end))
            return;
        if (start == n - 1 && end == n - 1) {
            result.add(current);
            return;
        }
        // marking as visited
        int temp = m[start][end];
        m[start][end] = 2;
        backtrack(result, m, n, current + 'L', start, end - 1);
        backtrack(result, m, n, current + 'R', start, end + 1);
        backtrack(result, m, n, current + 'U', start - 1, end);
        backtrack(result, m, n, current + 'D', start + 1, end);
        m[start][end] = temp;
    }
    
    public static boolean isSafe(int [][] m, int row, int col) {
        if (row < 0 || col < 0 || row >= m.length || col >= m[0].length || m[row][col] != 1)
            return false;
        return true;
    }
}
