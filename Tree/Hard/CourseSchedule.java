There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

Solution:

class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i=0; i<numCourses; i++)
            adjacent.add(new LinkedList<>());
        for (int i=0; i<p.length; i++)
            adjacent.get(p[i][1]).add(p[i][0]);
        boolean [] visited = new boolean[numCourses];
        boolean [] recursionStack = new boolean[numCourses];
        for (int i=0; i<numCourses; i++){
            if (isCycle(i, visited, recursionStack, adjacent))
                return false;
        }
        return true;
    } 
    public boolean isCycle(int i, boolean[] visited, boolean [] recursionStack, List<List<Integer>> adjacent) {
        if (recursionStack[i])
            return true;
        if (visited[i])
            return false;
        visited[i] = true;
        recursionStack[i] = true;
        List<Integer> children = adjacent.get(i);
        for (Integer child: children){
            if (isCycle(child, visited, recursionStack, adjacent))
                return true;
        }
        recursionStack[i] = false;
        return false;
    }
}
