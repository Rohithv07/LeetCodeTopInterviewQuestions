An IT company is working on a large project. The project is broken into N modules and distributed to different teams. The amount of time (in months) required to complete each module is given in an array duration[ ]. Two modules can be processed simultaneously only if their is no dependency between them and it is given that M modules have interdependecies. 
As the project manager, compute the minimum time required to complete the project.

Example 1:

Input:
N = 6 6
duration[] = {1, 2, 3, 1, 3, 2}
dependencies:
5 2
5 0
4 0 
4 1
2 3
3 1
Output: 
8
Explanation: 
graph
The Graph of dependency forms this and 
the project will be completed when Module 
1 is completed which takes 8 months.
Example 2:

Input:
N = 3 3
duration[] = {5, 5, 5}
dependencies:
0 1
1 2
2 0
Output: 
-1
Explanation: 
There is a cycle in the dependency graph 
hence the project cannot be completed.
Your Task:
Complete the function minTime() which takes N, M, duration array, and dependencies array as input parameter and return the minimum time required. Return -1 if the project can not be completed. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ M ≤ 2*105
1 ≤ duration[i] ≤ 105





class Solution {
    public int minTime(ArrayList<pair> dependency, int[] duration, int n, int m) {
        // code here
        int [] independent = new int [n + 5];
        int flag = 0;
        ArrayList<ArrayList<Integer>> graph = buildGraph(dependency, n, independent);
        for (int i=0; i<n; i++) {
            if (independent[i] == 0)
                flag = 1;
        }
        if (flag == 0)
            return -1;
        boolean [] visited = new boolean[n];
        boolean [] recursionStack = new boolean [n];
        int [] time = new int [n];
        Arrays.fill(time, -1);
        
        for (int i=0; i<n; i++) {
            if (independent[i] != 0)
                continue;
             if (isCycle(graph, visited, recursionStack, i))
                 return -1;
        }
        int result = 0;
        for (int i=0; i<n; i++) {
            if (independent[i] == 0)
                result = Math.max(result, dfs(i, graph, duration, time));
        }
        return result;
        // int count = 0;
        // for (int number : time) {
        //     System.out.println(number);
        //     if (number == -1)
        //         count += 1;
        // }
        
        // return Arrays.stream(time).max().getAsInt();
    }
    
    public ArrayList<ArrayList<Integer>> buildGraph(ArrayList<pair> dependency, int n, int [] independent) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (pair p : dependency) {
            graph.get(p.x).add(p.y);
            independent[p.y] ++;
        }
        return graph;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> graph, boolean [] visited, boolean [] recursionStack, int i) {
        recursionStack[i] = true;
        for (int child : graph.get(i)) {
            if (visited[child]) {
                if (recursionStack[child])
                    return true;
                continue;
            }
            visited[child] = true;
            if (isCycle(graph, visited, recursionStack, child))
                return true;
        }
        recursionStack[i] = false;
        return false;
    }
    
    public int dfs(int i, ArrayList<ArrayList<Integer>> graph, int [] duration, int [] time) {
        if (time[i] != -1)
            return time[i];
        int max = 0;
        for (int child : graph.get(i)) {
            max = Math.max(max, dfs(child, graph, duration, time));
        }
        time[i] = max + duration[i];
        return time[i];
    }
}
