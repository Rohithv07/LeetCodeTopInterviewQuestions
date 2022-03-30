Given a connected acyclic graph with n nodes and n-1 edges, count the pair of nodes that are at even distance(number of edges) from each other.


Example 1:

Input:
n = 3
graph = {{}, {2}, {1, 3}, {2}}
Output: 1
Explaination: Here there are three pairs {1,2},{1,3}
and {2,3} and only {1,3} has even distance between them.
i.e           1
             /
            2
           /
          3

Example 2:

Input:
n = 5
graph = {{}, {2,4}, {1,3}, {2}, {1,5}, {4}}
Output: 4
Explaination: There are four pairs {1,3},{1,5},{2,4}
and {3,5} which has even distance.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countOfNodes() which takes the array graph[] (given as Adjacency list) and its size n as input parameters and returns the count of pair of nodes that are at even distance from each other


Expected Time Complexity: O(V+E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ n ≤ 104'

// java equivalent but giving some error which cannot be fixed from my end currently
// problme in driver code

class Solution
{
    static int countOfNodes(ArrayList<Integer> graph[], int n) 
    {
        // code here
        boolean [] visited = new boolean [n];
        int [] count = new int [1];
        dfs(graph, visited, count, 1, 0);
        return count[0] * (count[0] - 1) / 2 + (n - count[0]) * (n - count[0] - 1) / 2;
    }
    
    static void dfs(ArrayList<Integer> graph[], boolean [] visited, int [] count, int node, int distance) {
        visited[node] = true;
        if (distance % 2 == 0) {
            count[0]++;
        }
        ArrayList<Integer> children = graph[node];
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(graph, visited, count, child, distance + 1);
            }
        }
    }
}




// submitted solution

class Solution{
    public:
    void dfs(vector<int> graph[],bool visited[],int &cnt,int src,int val)
    {
        visited[src] = true;
        if(val%2) cnt++;
        for(auto it:graph[src])
            if(!visited[it]) 
                dfs(graph,visited,cnt,it,val+1);
    }
    int countOfNodes(vector<int> graph[], int n)
    {
        bool visited[n+1] = {0};
        int cnt = 0;
        dfs(graph,visited,cnt,1,0);
        return cnt*(cnt-1)/2 + (n - cnt)*(n - cnt -1)/2;
    }
};



// editorial solution

class Solution {
  public:
// Dfs function to find count of nodes at 
// even distance 
void dfs(vector<int> graph[], int node, int dist[],  
                                    bool vis[], int c) 
{ 
    if (vis[node]) { 
        return; 
    } 
    // Set flag as true for current 
    // node in visited array 
    vis[node] = true; 
  
    // Insert the distance in 
    // dist array for current 
    // visited node u 
    dist[node] = c; 
  
    for (int i = 0; i < graph[node].size(); i++) { 
        // If its neighbours are not vis, 
        // run dfs for them 
        if (!vis[graph[node][i]]) { 
            dfs(graph, graph[node][i], dist, vis, c + 1); 
        } 
    } 
} 
  
int countOfNodes(vector<int> graph[], int n) 
{ 
    // bool array to 
    // mark visited nodes 
    bool vis[n + 1] = { false }; 
  
    // Integer array to 
    // compute distance 
    int dist[n + 1] = { 0 }; 
  
    dfs(graph, 1, dist, vis, 0); 
  
    int even = 0, odd = 0; 
  
    // Traverse the distance array 
    // and count the even and odd levels 
    for (int i = 1; i <= n; i++) { 
        if (dist[i] % 2 == 0) { 
            even++; 
        } 
        else { 
            odd++; 
        } 
    } 
  
    int ans = ((even * (even - 1)) + (odd * (odd - 1))) / 2; 
  
    return ans; 
} 
};