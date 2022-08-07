// https://practice.geeksforgeeks.org/contest/interview-series-62/problems/



//User function Template for Java

class Solution {
    static int solve(long n, int m, int k, int[][] volcano) {
        int minimumTime = 0;
        final int [][] direction = new int [][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean [][] visited = new boolean [(int)(n + 1)][m + 1];
        for (int i = 0; i < volcano.length; i++) {
            queue.offer(new int []{volcano[i][0], volcano[i][1]});
            visited[volcano[i][0]][volcano[i][1]] = true;;
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //System.out.println(time);
            //time++;
            for (int i = 0; i < size; i++) {
                int [] current = queue.poll();
                //System.out.println(current[0] + " " + current[1]);
                for (int [] dir : direction) {
                    int x = dir[0] + current[0];
                    int y = dir[1] + current[1];
                    if (x <= 0 || y <= 0 || x > (int)n || y > m || visited[x][y]) {
                        continue;
                    }
                    visited[x][y] = true;
                    queue.offer(new int []{x, y});
                }
            }
            time++;
        }
        return time - 1;
    }
}