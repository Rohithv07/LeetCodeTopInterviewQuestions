There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.



class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return new int []{0};
        }
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        int [] result = new int [numCourses];
        boolean [] visited = new boolean [numCourses];
        boolean [] recursionStack = new boolean[numCourses];
        List<Integer> storeTheOrder = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            if (isCycle(visited, recursionStack, prerequisites, graph, i, storeTheOrder)) {
                return new int []{};
            }
        }
        for (int i=0; i<storeTheOrder.size(); i++) {
            result[i] = storeTheOrder.get(i);
        }
        return result;
    }
    
    public boolean isCycle(boolean [] visited, boolean [] recursionStack, int [][] prerequisites, List<List<Integer>> graph, int node, List<Integer> currentCourse) {
        if (recursionStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        recursionStack[node] = true;
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (isCycle(visited, recursionStack, prerequisites, graph, child, currentCourse)) {
                return true;
            }
        }
        recursionStack[node] = false;
        currentCourse.add(node);
        return false;
    }
    
    public List<List<Integer>> buildGraph(int n, int [][] prerequisites) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            result.add(new ArrayList<>());
        }
        for (int [] p : prerequisites) {
            result.get(p[0]).add(p[1]);
        }
        return result;
    }
}