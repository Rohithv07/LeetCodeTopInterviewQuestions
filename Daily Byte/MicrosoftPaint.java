You are Given an image represented as a matrix. Each value in the matrix represents the color of an individual pixel. Given a new color represented as an integer and a starting row and column, transform every adjacent pixel to the starting pixel that has the same color to the new color.
Note: This is effectively implementing a “bucket fill” in a software like Microsoft paint.

Ex: Given the following image, row, column, and color…

image = [
  [0,1,1],
  [0,1,0],
  [1,1,1]
], row = 1, column = 1, color = 3 modify image to be as follows...
image = [
  [0, 3, 3],
  [0, 3, 0],
  [3, 3, 3],
].



class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor != newColor) {
            dfs(image, sr, sc, currentColor, newColor);
        }
        return image;
    }
    
    public void dfs(int [][] image, int i, int j, int color, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != color)
            return;
        image[i][j] = newColor;
        dfs(image, i+1, j, color, newColor);
        dfs(image, i-1, j, color, newColor);
        dfs(image, i, j-1, color, newColor);
        dfs(image, i, j+1, color, newColor);
    }
}
