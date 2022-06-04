The minions are very elitist in nature. If minion x admires minion y, then y thinks too highly of himself and does not admire x back. Also, if x admires y, x also admires everyone that y admires.
All the minions are going to be present at the Villain Con. They want to make sure that they do not dress in the same color as someone who admires them. 
There are N minions and M relations between them. The relations are given in a 2D array mat. Each relation is given in xi , yi format where yi admires xi. Find the minimum number of different colours that the minions will be dressing in. 

 

Example 1:

Input: 
N = 5, M = 6
mat = {{1, 3}, 
       {2, 3}, 
       {3, 4}, 
       {1, 4}, 
       {2, 5}, 
       {3, 5}}
Output: 3
Explaination:
If we assign red colour to 1 and 2,
green colour to 3, and blue colour to 4 and 5, then
every minion will have different coloured dresses
from the one who admires them.
Example 2:

Input:
N = 3, M = 2
mat = {{1,3},{2,3}}
Output:
2
Explanation:
If we assign red colour to 1 and 2, and green colour to 3, then the condition is satisfied.
Your Task:
You do not need to read input or print anything. Your task is to complete the function minColour() which takes N, M and mat[][] as input parameters and returns the minimum number of colours required.

 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N+M)

 

Constraints:
1 ≤ N ≤ 105
1 ≤ M ≤ 2*105  
1 ≤ xi , yi ≤ N





//User function Template for Java

class Solution{
    static int minColour(int n, int m, int mat[][]) {
        // code here
        Queue<Integer> queue = new LinkedList<>();
        int [] indegree = new int [n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] ma : mat) {
            indegree[ma[0]]++;
            graph.get(ma[1]).add(ma[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        return khansAlgoBFS(queue, indegree, graph);
    }
    
    static int khansAlgoBFS(Queue<Integer> queue, int [] indegree, List<List<Integer>> graph) {
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                int top = queue.poll();
                List<Integer> children = graph.get(top);
                for (Integer child : children) {
                    indegree[child]--;
                    if (indegree[child] == 0) {
                        queue.offer(child);
                    }
                }
            }
        }
        return count;
    }
}