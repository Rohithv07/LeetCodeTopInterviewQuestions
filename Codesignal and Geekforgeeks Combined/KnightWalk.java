Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.If it cannot reach the target position return -1.

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

Example 2:

Input:
N=8
knightPos[ ] = {7, 7}
targetPos[ ] = {1, 5}
Output:
4
Explanation:
Knight takes 4 steps to reach from
(7, 7) to (1, 5):
(4, 5) -> (6, 5) -> (5, 3) -> (7, 2) -> (1, 5).
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the inital position of Knight (KnightPos), the target position of Knight (TargetPos) and the size of the chess board (N) as an input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position.If it cannot reach the target position return -1.

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N

class Solution
{
    
    private final int [][] knightDirection = new int [][]{{2, 1}, {2, -1}, {-2, 1}, {-2, -1},
    {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
    
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n)
    {
        // Code here
        /*
        i, j -> i+2 j+1, i+2 j-1, i-2 j+1, i-2 j-1, i+1 j+2, i-1, j+2, i+1 j-2, i+1 j+2
        */
        Queue<int[]> queue = new LinkedList<>();
        boolean [][] visited = new boolean [n + 1][n + 1];
        queue.offer(new int []{knightPos[0], knightPos[1]});
        visited[knightPos[0]][knightPos[1]] = true;
        int minSteps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] currentPos = queue.poll();
                int x = currentPos[0];
                int y = currentPos[1];
                if (x == targetPos[0] && y == targetPos[1]) {
                    return minSteps;
                }
                for (int [] dir : knightDirection) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (newX < 0 || newX > n || newY < 0 || newY > n || visited[newX][newY]) {
                        continue;
                    }
                    visited[newX][newY] = true;
                    queue.offer(new int [] {newX, newY});
                }
            }
            minSteps++;
        }
        return minSteps;
    }
}