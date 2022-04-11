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

	public static int numberOfCells(int n, int m, int r, int c, int up, int down, char mat[][])
	{
		// code here
		
		Queue<Fourble> queue = new LinkedList<>();
		queue.offer(new Fourble(r, c, 0, 0));
		mat[r][c] = '1';
		int total = 0;
		while (!queue.isEmpty()) {
		    Fourble current = queue.poll();
		    int x = current.row;
		    int y = current.col;
		    int u = current.up;
		    int d = current.down;
		    if (y > 0 && mat[x][y - 1] == '.') {
		        queue.offer(new Fourble(x, y - 1, u, d));
		        mat[x][y - 1] = '1';
		    }
		    if (y < m - 1 && mat[x][y + 1] == '.') {
		        queue.offer(new Fourble(x, y + 1, u, d));
		        mat[x][y + 1] = '1';
		    }
		    if (x > 0 && mat[x - 1][y] == '.' && u != up) {
		        queue.offer(new Fourble(x - 1, y, u + 1, d));
		        mat[x - 1][y] = '1';
		    }
		    if (x < n - 1 && mat[x + 1][y] == '.' && d != down) {
		        queue.offer(new Fourble(x + 1, y, u, d + 1));
		        mat[x + 1][y] = '1';
		    }
		}
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        if (mat[i][j] == '1') {
		            total++;
		        }
		    }
		}
		return total;
	}

}

class Fourble {
    int row;
    int col;
    int up;
    int down;
    
    public Fourble(int row, int col, int up, int down) {
        this.row = row;
        this.col = col;
        this.up = up;
        this.down = down;
    }
}