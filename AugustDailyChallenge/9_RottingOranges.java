In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.


Solution:

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int freshCount = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if (grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                if (grid[i][j] == 1)
                    freshCount ++;
            }
        }
        int [][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int time = 0;
        while (!queue.isEmpty() && freshCount > 0){
            time ++;
            int size = queue.size();
            while (size > 0){
                int [] xy = queue.poll();
                for (int [] d: direction){
                    int x = xy[0] + d[0];
                    int y = xy[1] + d[1];
                    
                    //Continue if no fresh orange or grid out of bound
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    queue.add(new int[]{x, y});
                    grid[x][y] = 2;
                    freshCount --;
                    
                }
                size --;
            }
        }
        return freshCount == 0 ? time : -1;
    }
}
