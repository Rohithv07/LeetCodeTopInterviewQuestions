Given a matrix of  size n x m. Your task is to make Zeroes, that means in whole matrix when you find a zero, convert its upper, lower, left, and right value to zero and make that element the sum of the upper, lower, left and right value. Do the following tasks according to the initial matrix.
 

Example 1:

Input: matrix = {{1, 2, 3, 4},
                 {5, 6, 0, 7}, 
                 {8, 9, 4, 6},
                 {8, 4, 5, 2}}
Output: {{1, 2, 0, 4}, 
         {5, 0, 20, 0},
         {8, 9, 0, 6}, 
         {8, 4, 5, 2}}
Explanation: As matrix[1][2] = 0, we will
perform the operation here. Then matrix[1][2]
= matrix[0][2] + matrix[2][2] + matrix[1][1] 
+ matrix[1][3] and matrix[0][2] = matrix[2][2] 
= matrix[1][1] = matrix[1][3] = 0.
Example 2:

Input: matrix = {{1, 2}, 
                 {3, 4}}
output: {{1, 2}, 
         {3, 4}}

Your Task:
You don't need to read or print anything. Your task is to complete the function MakeZeros() which takes the matrix as input parameter and does the given task according to initial matrix. You don't need to return anything. The driver code prints the modified matrix itself in the output.
 

Expected Time Complexity: O(n * m)
Expected Space Complexity: O(n * m)
 

Constraints:
1 ≤ n, m ≤ 100
1 ≤ matrix[i][j] ≤ 100, where 0 ≤ i ≤ n and 0 ≤ j ≤ m

class Solution
{
    public void  MakeZeros(int[][] matrix)
    {
        // code here
        if (matrix == null || matrix.length == 0)
            return;
        bfs(matrix);
    }
    
    public void bfs(int [][] matrix) {
        final int [][] directions = new int [][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] backup = new int [row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int []{i, j});
                }
                backup[i][j] = matrix[i][j];
            }
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= row || newY < 0 || newY >= col)
                    continue;
                sum += backup[newX][newY];
                matrix[newX][newY] = 0;
            }
            matrix[x][y] = sum;
            sum = 0;
        }
    }
}
