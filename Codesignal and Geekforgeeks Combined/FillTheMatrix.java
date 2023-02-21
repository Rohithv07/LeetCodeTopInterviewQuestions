Given a matrix with dimensions N x M, entirely filled with zeroes except for one position at co-ordinates X and Y containing '1'. Find the minimum number of iterations in which the whole matrix can be filled with ones.
Note: In one iteration, '1' can be filled in the 4 neighbouring elements of a cell containing '1'.


Example 1:

Input:
N = 2, M = 3
X = 2, Y = 3
Output: 3 

Explanation: 3 is the minimum possible 
number of iterations in which the
matrix can be filled.
Example 2:

Input:
N = 1, M = 1
X = 1, Y = 1 
Output: 0

Explanation: The whole matrix is 
already filled with ones.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minIterations() which takes the dimensions of the matrix N and M and the co-ordinates of the initial position of '1' ie X and Y as input parameters and returns the minimum number of iterations required to fill the matrix.


Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N, M ≤ 103
1 ≤ X ≤ N
1 ≤ Y ≤ M 


// there is a n * m matrix and a single cell is currently having 1. We can fill the other 4 dir of
// this cell to 1, what is the min iteration to full fill the matrix with 1.

class Solution
{
	public static int minIteration(int n, int m, int x, int y){
		//code here
		if (n == 1 && m == 1 && x == 1 && y == 1)
		    return 0;
		Queue<int[]> queue = new LinkedList<>();
		boolean [][] visited = new boolean [n][m];
		queue.offer(new int []{x - 1, y - 1});
		visited[x-1][y-1] = true;
		int steps = 0;
		final int [][] directions = new int [][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		while (!queue.isEmpty()) {
		    steps += 1;
		    int size = queue.size();
		    for (int i=0; i<size; i++) {
		        int [] current = queue.poll();
		        int pos1 = current[0];
		        int pos2 = current[1];
		        for (int [] dir : directions) {
		            int newX = dir[0] + pos1;
		            int newY = dir[1] + pos2;
		            if (newX < 0 || newY < 0 || newX >= n || newY >= m || visited[newX][newY])
		                continue;
		            queue.offer(new int [] {newX, newY});
		            visited[newX][newY] = true;
		        }
		    }
		}
		
		return steps - 1;
		
	}
}