We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Constraints:

1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
ai < bi
All the pairs of dislikes are unique.



class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        boolean [][] graph = new boolean [n][n];
        for (int [] dislike : dislikes) {
            graph[dislike[0] - 1][dislike[1] - 1] = true;
            graph[dislike[1] - 1][dislike[0] - 1] = true;
        }
        int [] group = new int [n];
        // 0 not visited, other than 0 it indicates visited
        // 1 red color
        // -1 blue color
        for (int i=0; i<n; i++) {
            if (group[i] == 0 && !dfs(graph, group, 1, i))
                return false;
        }
        return true;
    }
    
    public boolean dfs(boolean [][] graph, int [] group, int color, int index) {
        group[index] = color;
        for (int i=0; i<graph.length; i++) {
            if (graph[index][i]) {
                if (group[i] == color)
                    return false;
                if (group[i] == 0 && !dfs(graph, group, -color, i))
                    return false;
            }
        }
        return true;
    }
}