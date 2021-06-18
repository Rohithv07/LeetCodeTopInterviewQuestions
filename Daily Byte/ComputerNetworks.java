/*
You are given a two-dimensional matrix containing only ones and zeroes representing a computer network. Every one in the matrix represents a server and every zero represents an empty space. Two servers within the network can communicate if they are either in the same row or the same column. Return the total number of servers that can communicate with at least one other server.

Ex: Given the following matrix…

matrix = [
  [1, 0],
  [1, 0],
], return 2 (both servers are in the same column and can therefore communicate with one another).
Ex: Given the following matrix…

matrix = [
  [1, 0],
  [0, 1],
], return 0.

*/


class Solution {
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int connectedServer = 0;
        int row = grid.length;
        int col = grid[0].length;
        int [] rowOneSum = new int [row];
        int [] colOneSum = new int [col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    rowOneSum[i] += 1;
                    colOneSum[j] += 1;
                }
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1 && (rowOneSum[i] > 1 || colOneSum[j] > 1)) {
                    connectedServer += 1;
                }
            }
        }
        return connectedServer;
    }
}
