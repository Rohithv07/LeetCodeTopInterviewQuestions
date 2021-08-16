Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left cell to bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j). 

Note: It is assumed that negative cost cycles do not exist in the input matrix.
 

Example 1:

Input: grid = {{9,4,9,9},{6,7,6,4},
{8,3,3,7},{7,4,9,10}}
Output: 43
Explanation: The grid is-
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10
The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
Example 2:

Input: grid = {{4,4},{3,7}}
Output: 14
Explanation: The grid is-
4 4
3 7
The minimum cost is- 4 + 3 + 7 = 14.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function minimumCostPath() which takes grid as input parameter and returns the minimum cost to react at bottom right cell from top left cell.
 

Expected Time Compelxity: O(n2*log(n))
Expected Auxiliary Space: O(n2) 
 

Constraints:
1 ≤ n ≤ 500
1 ≤ cost of cells ≤ 1000


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        if (row == 1 && col == 1)
            return grid[0][0];
        // taking the values inside the cell as weight, apply djikstra
        PriorityQueue<Triple> minHeap = new PriorityQueue<>((t1, t2) -> t1.cost - t2.cost);
        minHeap.offer(new Triple(0, 0, grid[0][0]));
        int result = 0;
        grid[0][0] = -1;
        final int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            Triple current = minHeap.poll();
            int x = current.row;
            int y = current.col;
            int currentCost = current.cost;
            if (x == row - 1 && y == col - 1)
                return currentCost;
            for (int [] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] == -1)
                    continue;
                minHeap.offer(new Triple(newX, newY, currentCost + grid[newX][newY]));
                grid[newX][newY] = -1;
            }
        }
        return 0;
    }
}

class Triple {
    int row;
    int col;
    int cost;
    public Triple(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}