An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

Example 1:

Input: image = {{1,1,1},{1,1,0},{1,0,1}},
sr = 1, sc = 1, newColor = 2.
Output: {{2,2,2},{2,2,0},{2,0,1}}
Explanation: From the center of the image 
(with position (sr, sc) = (1, 1)), all 
pixels connected by a path of the same color
as the starting pixel are colored with the new 
color.Note the bottom corner is not colored 2, 
because it is not 4-directionally connected to 
the starting pixel.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function floodFill() which takes image, sr, sc and newColor as input paramater and returns the image after flood filling.
 

Expected Time Compelxity: O(n*m)
Expected Space Complexity: O(n*m)
 

Constraints:
1 <= n <= m <= 100
0 <= pixel values <= 10
0 <= sr <= (n-1)
0 <= sc <= (m-1)



// using bfs

class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        if (image == null || image.length == 0)
            return new int [][]{};
        int row = image.length;
        int col = image[0].length;
        bfs(image, sr, sc, newColor, row, col);
        return image;
    }
    
    public void bfs(int [][] image, int sr, int sc, int newColor, int row, int col) {
        Queue<int []> queue = new LinkedList<>();
        boolean [][] visited = new boolean [row][col];
        int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[sr][sc] = true;
        int currentColor = image[sr][sc];
        queue.offer(new int [] {sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || visited[newX][newY] || image[newX][newY] != currentColor) {
                    continue;
                }
                image[newX][newY] = newColor;
                visited[newX][newY] = true;
                queue.offer(new int []{newX, newY});
            }
        }
    }
}


// using dfs

class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        if (image == null || image.length == 0) {
            return new int [][] {};
        }
        int row = image.length;
        int col = image[0].length;
        int currentColor = image[sr][sc];
        if (currentColor != newColor)
            dfs(image, sr, sc, row, col, newColor, currentColor);
        return image;
    }
    
    public void dfs(int [][] image, int pos1, int pos2, int row, int col, int newColor, int currentColor) {
        if (pos1 < 0 || pos2 < 0 || pos1 >= row || pos2 >= col || image[pos1][pos2] != currentColor) {
            return;
        }
        image[pos1][pos2] = newColor;
        dfs(image, pos1+1, pos2, row, col, newColor, currentColor);
        dfs(image, pos1-1, pos2, row, col, newColor, currentColor);
        dfs(image, pos1, pos2+1, row, col, newColor, currentColor);
        dfs(image, pos1, pos2-1, row, col, newColor, currentColor);
    }
}