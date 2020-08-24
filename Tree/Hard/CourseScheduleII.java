There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

Solution:

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacent = new ArrayList();
        for (int i=0; i<numCourses; i++)
            adjacent.add(new LinkedList<>());
        for (int i=0; i<prerequisites.length; i++) {
            adjacent.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        List<Integer> list = new ArrayList<>();
        boolean [] visited = new boolean[numCourses];
        boolean [] recursionStack = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (isCycle(i, visited, recursionStack, adjacent, list))
                return new int[0];
        }
        int [] result = new int [list.size()];
        for (int i=0; !list.isEmpty(); i++) {
            result[i] = list.remove(0);
        }
        return result;
    }
    public boolean isCycle(int i, boolean[] visited, boolean[] recursionStack, List<List<Integer>> adjacent, List<Integer> list) {
        if (recursionStack[i])
            return true;
        if (visited[i])
            return false;
        recursionStack[i] = true;
        visited[i] = true;
        List<Integer> children = adjacent.get(i);
        for (Integer child: children) {
            if (isCycle(child, visited, recursionStack, adjacent, list))
                return true;
        }
        recursionStack[i] = false;
        list.add(i);
        return false;
    }
}
