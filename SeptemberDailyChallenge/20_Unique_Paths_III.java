/* My thought process
For most of the grid problem, the common approach is to use the dfs approach. So I initially coded the dfs function, written the exiting condition and all the dfsMovement condition to left, right, top, down and finally when I run it, I was not gettin the correct output. 
So I just looks through the disccus section and there is solutions with the backtracking applied. So I once again looked and find that we need to find all the possible path and get the total count. Yes, eventhogh we found a path, we need to again start from the beginning to search for another possible path. SO we need to use thebacktracking along wiht the dfs.
Backtracking idea was used from one of the code from the discuss section and I understood why we need it.

So find a path, backtrack, find any other path, backtrack, find any other path, backtrack until there is no possible path throught the non obstacles and finallu return the count.
Thats the whole idea behind this problem.
*/


class Solution {
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length; 
        int col = grid[0].length;
        int noOfNonObstacles = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 0)
                    noOfNonObstacles += 1;
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1)
                    return helper(grid, i+1, j, noOfNonObstacles) +
                    helper(grid, i-1, j, noOfNonObstacles) +
                    helper(grid, i, j-1, noOfNonObstacles) + 
                    helper(grid, i, j+1, noOfNonObstacles);
            }
        }
        return 0;
    }
    public int helper(int [][] grid, int i, int j, int noOfNonObstacles) {
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == -1 || grid[i][j] == 1)
            return 0;
        if (grid[i][j] == 2)  {
            if (noOfNonObstacles == 0)
                return 1;
            return 0;
        } // check if we reach the destination but still there are non obstacles unvisited
        if (noOfNonObstacles == 0)
            return 0;  // we didnt reach the destination but our non Obstacles are fully visited
        grid[i][j] = 1;  // let it denote visited
        int possibleWay1 = helper(grid, i+1, j, noOfNonObstacles-1);
        int possibleWay2 = helper(grid, i-1, j, noOfNonObstacles-1);
        int possibleWay3 = helper(grid, i, j-1, noOfNonObstacles-1);
        int possibleWay4 = helper(grid, i, j+1, noOfNonObstacles-1);
        grid[i][j] = 0; //for backtracking
        return possibleWay1 + possibleWay2 + possibleWay3 + possibleWay4;
}
    
}
