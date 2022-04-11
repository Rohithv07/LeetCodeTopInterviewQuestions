Geek is in a maze of size N * M. Each cell in the maze is made of either '.' or '#'. An empty cell is represented by '.' and an obstacle is represented by '#'. If Geek starts at cell (R, C), find how many different empty cells he can pass through while avoiding the obstacles. He can move in any of the four directions but he can move up at most U times and he can move down atmost D times.

 

Example 1:

Input: 
N = 3, M = 3
R = 1, C = 0
U = 1, D = 1
mat = {{'.', '.', '.'},
       {'.', '#', '.'},
       {'#', '.', '.'}}
Output: 5
Explanation: Geek can reach 
(1, 0), (0, 0), (0, 1), (0, 2), (1, 2) 


Example 2:

Input: 
N = 3, M = 4
R = 1, C = 0
U = 1, D = 2 
mat = {{'.', '.', '.'}, 
       {'.', '#', '.'}, 
       {'.', '.', '.'},
       {'#', '.', '.'}} 
Output: 10
Explanation: Geek can reach all the 
cells except for the obstacles.
 

Your Task:  
You don't need to read input or print anything. Complete the function numberOfCells() which takes N, M, R, C, U, D and the two dimensional character array mat[][] as input parameters and returns the number of cells geek can visit.


Constraints:
1 ≤ N*M ≤ 106
mat[i][j] = '#" or '.'
0 ≤ R ≤ N-1
0 ≤ C ≤ M-1
mat[R][C] = '.'



class Solution{

	public static int numberOfCells(int n, int m, int r, int c, int u, int d, char mat[][])
	{
		// code here
		// base condition
		if (mat[r][c] == '#') {
		    return 0;
		}
		bfs(n, m, r, c, u, d, mat);
		int countOfPossibleCells = 0;
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        if (mat[i][j] == '1') {
		            countOfPossibleCells++;
		        }
		    }
		}
		return countOfPossibleCells;
	}
	
	public static void bfs(int n, int m, int startingRow, int startingCol, int u, int d, char [][] mat) {
	    Queue<Fourble> queue = new LinkedList<>();
	    queue.offer(new Fourble(startingRow, startingCol, 0, 0));
	    mat[startingRow][startingCol] = '1';
	    while (!queue.isEmpty()) {
	        Fourble current = queue.poll();
	        int row = current.row;
	        int col = current.col;
	        int upperCount = current.upperCount;
	        int lowerCount = current.lowerCount;
	        // left
	        if (col > 0 && mat[row][col - 1] == '.') {
	            mat[row][col - 1] = '1';
	            queue.offer(new Fourble(row, col - 1, upperCount, lowerCount));
	        }
	        // right 
	        if (col < m - 1 && mat[row][col + 1] == '.') {
	            mat[row][col + 1] = '1';
	            queue.offer(new Fourble(row, col + 1, upperCount, lowerCount));
	        }
	        // up
	        if (row > 0 && upperCount != u && mat[row - 1][col] == '.') {
	            mat[row - 1][col] = '1';
	            queue.offer(new Fourble(row - 1, col, upperCount + 1, lowerCount));
	        }
	        // down
	        if (row < n - 1 && lowerCount != d && mat[row + 1][col] == '.') {
	            mat[row + 1][col] = '1';
	            queue.offer(new Fourble(row + 1, col, upperCount, lowerCount + 1));
	        }
	    }
	}

}

class Fourble {
    int row;
    int col;
    int upperCount;
    int lowerCount;
    
    public Fourble(int row, int col, int upperCount, int lowerCount) {
        this.row = row;
        this.col = col;
        this.upperCount = upperCount;
        this.lowerCount = lowerCount;
    }
}