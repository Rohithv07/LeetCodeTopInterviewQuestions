There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

 

Example 1:


Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean 
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean 
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean 
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 

Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105



class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        int row = heights.length;
        int col = heights[0].length;
        boolean [][] pacific = new boolean [row][col];
        boolean [][] atlantic = new boolean [row][col];
       // Cells on the border (first/last row, and first/last column) are guaranteed to get into the ocean. You start off with the border cells and go from there to explore the inner land.
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, pacific, heights[0][i]);
            dfs(heights, row - 1, i, atlantic, heights[row - 1][i]);
        }
        
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, col - 1, atlantic, heights[i][col - 1]);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> currentResult = new ArrayList<>();
                    currentResult.add(i);
                    currentResult.add(j);
                    result.add(new ArrayList<>(currentResult));
                }
            }
        }
        return result;
    }
    
    private void dfs(int [][] heights, int row, int col, boolean [][] visited, int beforeHeight) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length || visited[row][col] || beforeHeight > heights[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
    }
}