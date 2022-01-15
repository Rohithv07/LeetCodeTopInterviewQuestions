Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.

 

Example 1:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:

Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
 

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the inital position of Knight (KnightPos), the target position of Knight (TargetPos) and the size of the chess board (N) as an input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position.

 

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

 

Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N



class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n)
    {
        // Code here
        Queue<int[]> queue = new LinkedList<>();
        int jumps = 0;
        int [][] directions = new int [][]{
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-1, -2}, {1, -2}
        };
        queue.offer(knightPos);
        boolean [][] visited = new boolean [n][n];
        visited[knightPos[0] - 1][knightPos[1] - 1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int [] currentPosition = queue.poll();
                int rowPos = currentPosition[0];
                int colPos = currentPosition[1];
                if (rowPos == targetPos[0] && colPos == targetPos[1]) {
                    return jumps;
                }
                for (int [] dir : directions) {
                    int rowJump = dir[0] + rowPos;
                    int colJump = dir[1] + colPos;
                    if (rowJump <= 0 || rowJump > n || colJump <= 0 || colJump > n || visited[rowJump - 1][colJump - 1]) {
                        continue;
                    }
                    queue.offer(new int []{rowJump, colJump});
                    visited[rowJump - 1][colJump - 1] = true;
                }
            }
            jumps += 1;
        }
        return jumps;
    }
}