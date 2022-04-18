



// https://practice.geeksforgeeks.org/contest/interview-series-46/problems/#

// https://youtu.be/vLpolU5kDhs

//User function Template for Java

class Solution{
    
    private final int [][] direction = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
	int water_flow(int [][] mat, int n, int m) {
		//Write your code here
		boolean [][] visited1 = new boolean [n][m];
		boolean [][] visited2 = new boolean [n][m];
	    
	    // we are just doing the reverse
	    // instead of finding all the cells where water flows to both oceans
	    // we are find the cells from the which water from indian can reach how many cells
	    // water from arabian see can reach how many cells
	    // then the common count will be take as our answer
	    
	    // indian ocean - top cell and left most cell
	    for (int i = 0; i < m; i++) {
	        if (!visited1[0][i]) {
	            dfs1(mat, 0, i, n, m, visited1);
	        }
	    }
	    for (int i = 0; i < n; i++) {
	        if (!visited1[i][0]) {
	            dfs1(mat, i, 0, n, m, visited1);
	        }
	    }
	    
	    // arabian see - bottom cell and right most cell
	    for (int i = 0; i < m; i++) {
	        if (!visited2[n - 1][i]) {
	            dfs1(mat, n - 1, i, n, m, visited2);
	        }
	    }
	    for (int i = 0; i < n; i++) {
	        if (!visited2[i][m - 1]) {
	            dfs1(mat, i, m - 1, n, m, visited2);
	        }
	    }
	    
	    int countCells = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (visited1[i][j] && visited2[i][j]) {
	                countCells++;
	            }
	        }
	    }
	    return countCells;
	}
	
	private void dfs1(int [][] mat, int row, int col, int n, int m, boolean [][] visited) {
	    visited[row][col] = true;
	    for (int [] dir : direction) {
	        int nextRow = dir[0] + row;
	        int nextCol = dir[1] + col;
	        if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || visited[nextRow][nextCol] || mat[nextRow][nextCol] < mat[row][col]) {
	            continue;
	        }
	        dfs1(mat, nextRow, nextCol, n, m, visited);
	    }
	}
}