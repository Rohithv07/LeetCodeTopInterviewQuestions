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