// here we can do dfs and count the number of friends accoridng to the condition
// first we go throught the roq ansd check whether if it is not visited, if not visited we do the dfs column wise
// inside the dfs funxction, if we already visited a particulkar item just return
// else just mark the current as visited for do the traverse on the column
// if its not visited and the corresponding cell = 1, do the dfs
class Solution {
    public int findCircleNum(int[][] M) {
        int friendCount = 0;
        // a boolean array for visited
        int row = M.length;
        boolean [] visited = new boolean[row];
        for (int i=0; i<row; i++) {
            if (!visited[i]) {
                // do the dfs and increase the count
                dfs(M, visited, i);
                friendCount += 1;
            }
        }
        return friendCount;
    }
    public void dfs(int [][] M, boolean [] visited, int current) {
        if (visited[current])
            return;
        visited[current] = true;
        for (int i=0; i<M[current].length; i++) {
            if (!visited[i] && M[current][i] == 1)
                // continue the dfs
                dfs(M, visited, i);
        }
    }
}