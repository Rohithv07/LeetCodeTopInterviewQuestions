Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall.
Note: There are only a single source and a single destination.
 

Example 1:

Input: grid = {{3,0,3,0,0},{3,0,0,0,3}
,{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}}
Output: 0
Explanation: The grid is-
3 0 3 0 0 
3 0 0 0 3 
3 3 3 3 3 
0 2 3 0 0 
3 0 0 1 3 
There is no path to reach at (3,1) i,e at 
destination from (4,3) i,e source.
Example 2:

Input: grid = {{1,3},{3,2}}
Output: 1
Explanation: The grid is-
1 3
3 2
There is a path from (0,0) i,e source to (1,1) 
i,e destination.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function is_Possible() which takes the grid as input parameter and returns boolean value true if there is a path otherwise returns false.
 

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)
 

Constraints:
1 ≤ n ≤ 500




class Solution
{
    //Function to find whether a path exists from the source to destination.
    private final int [][] direction = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        int destinationRow = 0;
        int destinationCol = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int [] {i, j});
                    grid[i][j] = 0;
                }
                else if (grid[i][j] == 2) {
                    destinationRow = i;
                    destinationCol = j;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if (x == destinationRow && y == destinationCol) {
                    return true;
                }
                for (int [] dir : direction) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] == 0) {
                        continue;
                    }
                    queue.offer(new int [] {newX, newY});
                    grid[newX][newY] = 0;
                }
            }
        }
        return false;
    }
}